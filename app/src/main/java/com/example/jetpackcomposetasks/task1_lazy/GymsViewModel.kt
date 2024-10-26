package com.example.jetpackcomposetasks.task1_lazy

import androidx.lifecycle.ViewModel

// ViewModel Library { Mainly it's store and save the state from being lost when configuration changes happen }
/*
* -> Why we don't use the activity or the fragment to this job instead of delegate this to the viewModel?
*    _ 1- Because the UI Class "Activity and Fragment" has many tasks like { UI logic, UI state, Cashing and network request }
       So the view model come to take some of this responsibilities to make the code easy to maintain and testable
       { UI state, Cashing and network request }.
       2- To avoid the memory leaks " assume that you click on an item to receive data from API and we the process occurs you
            moved to another activity so the process will stay when the UI which is responsible to receive this data died ".
       3- The ViewModel is life-Cycle Aware. <<by viewModelProvider >> */

class GymsViewModel(): ViewModel() {
    fun getGyms() = itemList()
}
