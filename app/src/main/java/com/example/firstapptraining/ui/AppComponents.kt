package com.example.firstapptraining.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapptraining.R
import com.example.firstapptraining.data.UserDataUiEvents
import com.example.firstapptraining.data.UserInputScreenState
import com.example.firstapptraining.ui.screens.TextComponent

@Composable
fun TopBar(value: String){
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "$value",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Native Logo"
        )

    }
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar("")
}


@Composable
fun TextFieldComponent(
    onTextChanged: (name:String) -> Unit
){
    var currentValue by remember {
        mutableStateOf("")
    }

    val localFocusManager = LocalFocusManager.current

   OutlinedTextField(
       modifier = Modifier.fillMaxWidth(),
       value = currentValue,
       onValueChange = {
           currentValue = it
            onTextChanged(it)
       },
       placeholder = {
           Text(text = "Enter your name", fontSize = 18.sp)
       },
       textStyle = TextStyle.Default.copy(fontSize = 24.sp),
       keyboardOptions = KeyboardOptions(
           imeAction = ImeAction.Done
       ),
       keyboardActions = KeyboardActions {
           localFocusManager.clearFocus()
       }
   )

}


@Preview(showBackground = true)
@Composable
fun TextFieldComponentPrieview(){
    TextFieldComponent({name -> UserInputViewModel().onEvent(UserDataUiEvents.UserNameEntered(name))})
}

@Composable
fun AnimalCard(image:Int, selected: Boolean, animalSelected: (animalName: String) -> Unit){
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(24.dp)
            .size(130.dp),
        elevation = CardDefaults.cardElevation(4.dp)

    ){

        val localFocusManager = LocalFocusManager.current
        Box (
            modifier = Modifier
                .fillMaxSize()
                .border(
                    width = 1.dp,
                    color = if (selected) Color.Green else Color.Transparent
                )
        ){
            Image(
                modifier = Modifier
                    .padding(16.dp)
                    .wrapContentWidth()
                    .wrapContentHeight()
                    .clickable {
                        val animalName = if (image == R.drawable.cattet) "Cat" else "Dog"
                        animalSelected.invoke(animalName)
                        localFocusManager.clearFocus()
                    },
                painter = painterResource(id = image),
                contentDescription = "Animal Image",

                )
        }

    }

}

@Preview()
@Composable
fun AnimalCardPreview(){
    AnimalCard(R.drawable.cattet,false,{"Dog"})
}


@Composable
fun ButtonComponent(
    goToDetailsScreen : () -> Unit
){
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {goToDetailsScreen.invoke()}
    ){
        TextComponent(textValue = "Go to Details Screen", textSize = 18.sp, colorValue = Color.White)
    }
}