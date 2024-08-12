package com.example.firstapptraining.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstapptraining.R
import com.example.firstapptraining.data.UserDataUiEvents
import com.example.firstapptraining.ui.AnimalCard
import com.example.firstapptraining.ui.ButtonComponent
import com.example.firstapptraining.ui.TextFieldComponent
import com.example.firstapptraining.ui.TextFieldComponentPrieview
import com.example.firstapptraining.ui.TopBar
import com.example.firstapptraining.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)

        ){
            TopBar("Hi there \uD83D\uDE0A")

            TextComponent(textValue = "Let's learn about You !",
                textSize = 24.sp
            )
            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "This app will prepare a details page based on input",
                textSize = 18.sp
            )
            Spacer(modifier = Modifier.size(60.dp))
            TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(UserDataUiEvents.UserNameEntered(it))
            })

            Spacer(modifier = Modifier.size(18.dp))

            TextComponent(textValue = "What do you like?", textSize = 18.sp)

            Row(
                modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.cattet, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Cat")

                AnimalCard(image = R.drawable.labrador, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected == "Dog")
            }

            Spacer(modifier = Modifier.weight(1f))
            if(userInputViewModel.isValidState()) {
                ButtonComponent (
                    goToDetailsScreen = {
                        //TODO: Dokończyć przejście do nastepnej strony oraz druga stronę
                        //
                    }
                )
            }




        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen( UserInputViewModel())
}

@Composable
fun TextComponent(
    textValue: String,
    textSize: TextUnit,
    colorValue: Color = Color.Black
){
    Text(
        text = textValue,
        fontSize = textSize,
        color = colorValue,
        fontWeight = FontWeight.Light
    )
}

@Preview
@Composable
fun TextComponentPreview(){
    TextComponent(textValue = "Native text", textSize = 24.sp, colorValue = Color.Red)
}