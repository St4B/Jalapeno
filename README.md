# Jalapeno
Sample app used to present navigation across tabs with BottomNavigationView & Jetpack Navigation

## Expectation
A common problem when using BottomNavigationView is to navigate between destinations that belong to different stacks (aka Tabs). What we would like to have, is a single navigation graph that can be included in the graph of each tab. As a result, we will have only one place to define our destinations which is going to be reusable. By doing so, we have more scalable and maintanable apps. 

## Limitation
In our approach there is a limitation. By design, every navigation graph has a starting destination, which means that we need to navigate there in order to start using the destinations and actions of the graph. This is not the desirable behaviour, as we would like to navigate immediately to the different destinations without seeing any other destination.

## Solution
The solution is to create non-ui fragment which will be called Router. This fragment is going to be our starting destination. This fragment will be responsible for defining which is our destination, navigate us to it and pop itself. In addition, we need to pass some params to this fragment. We need to pass an enum that helps us to identify every destination, as well as the params that each destination needs.

## Example
In our sample app we have two tabs. In the first one we see a 'Dashboard' which contains a widget that navigate us to the details of our favorite pizza. The second tab contains a list of pizzas. If we press on each item we navigate to the details of each item (Which in a real case scenario could be a whole different destination for each item). 

#### Defining sharing destinations graph
We started by adding all the possible destinations in the graph. In addition we defined our router fragment (aka PizzaDetailsRouterFragment) as starting destination and we added actions for every destination in the graph.
```
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    app:startDestination="@id/fragment_details_router"
    xmlns:app="http://schemas.android.com/apk/res-auto" android:id="@+id/pizza_details">

        <fragment
            android:id="@+id/fragment_details_router"
            android:label="Router"
            android:name="com.vaios.jalapeno.list.PizzaDetailsRouterFragment" >

                <action
                    android:id="@+id/go_to_diavola"
                    app:popUpToInclusive="true"
                    app:popUpTo="@id/fragment_details_router"
                    app:destination="@id/fragment_diavola" />

                <action
                    android:id="@+id/go_to_bbq"
                    app:popUpToInclusive="true"
                    app:popUpTo="@id/fragment_details_router"
                    app:destination="@id/fragment_bbq" />

                <action
                    android:id="@+id/go_to_pepperoni"
                    app:popUpToInclusive="true"
                    app:popUpTo="@id/fragment_details_router"
                    app:destination="@id/fragment_pepperoni" />

        </fragment>

        <fragment
            android:id="@+id/fragment_diavola"
            android:label="@string/pizza_diavola"
            android:name="com.vaios.jalapeno.list.DiavolaFragment" />

        <fragment
            android:id="@+id/fragment_bbq"
            android:label="@string/pizza_bbq"
            android:name="com.vaios.jalapeno.list.BBQFragment" />

        <fragment
            android:id="@+id/fragment_pepperoni"
            android:label="@string/pizza_pepperoni"
            android:name="com.vaios.jalapeno.list.PepperoniFragment" />

</navigation>
```

#### Include in other tabs is made easy
In order to use our sharing destinations in different tabs, we just need to include the sharing navigation graph. _Be careful when including the same graph in different tabs while using deeplinks. In that case you will need to define a unique name for the included graph. In other case a runtime exception will occur._
```
    <include
        app:graph="@navigation/pizza_details" />
```

#### Navigating with the help of Router fragment
On create of our router we define our destination and we navigate there. _It seems that pop up does not work in every case, so the best approach is to define it explicity in NavOptions and use it while navigating. In other case the router fragment will not pop up itself for sure._
```
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // In order to pop router
        val navOptions =
            NavOptions.Builder().setPopUpTo(R.id.fragment_details_router, true).build()

        // Define destination and navigate there
        when(arguments?.getSerializable(BUNDLE_KEY_PIZZA_TYPE) as PizzaType) {
            PizzaType.BBQ -> findNavController().navigate(R.id.fragment_bbq, null, navOptions)
            PizzaType.DIAVOLA -> findNavController().navigate(R.id.fragment_diavola, null, navOptions)
            PizzaType.PEPPERONI -> findNavController().navigate(R.id.fragment_pepperoni, null, navOptions)
        }
    }
```

## Gains
- SSOT for our navigation.
- Having transition even by using deeplinks. (In the source code of NavController, it seems that transitions are not supported yet for deeplinks).
