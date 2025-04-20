package com.example.room.ui.theme

@Composable
fun MainScreen(navController: NavController, viewModel: UserViewModel) {
    val users by viewModel.users.observeAsState(emptyList())
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = firstName, onValueChange = { firstName = it }, label = { Text("Firstname") })
        TextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Lastname") })

        Button(onClick = {
            viewModel.insertUser(User(firstName = firstName, lastName = lastName))
            firstName = ""
            lastName = ""
        }) {
            Text("INSERT")
        }

        LazyColumn {
            items(users) { user ->
                Text(
                    text = "User: ${user.firstName} ${user.lastName}",
                    modifier = Modifier
                        .clickable {
                            navController.navigate("details/${user.userId}")
                        }
                        .padding(8.dp)
                )
            }
        }
    }
}
