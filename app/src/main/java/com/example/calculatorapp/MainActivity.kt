package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.mariuszgromada.math.mxparser.Expression
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			CalculatorAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
				) {
					FinalApp()
				}
			}
		}
	}
}

@Composable
fun FinalApp() {

	Greeting()
}

@Composable
fun Greeting() {
	var text by remember { mutableStateOf("0") }

	Column {
		Text(
			text = text,
			fontSize = 55.sp, fontFamily = FontFamily.SansSerif,
			textAlign = TextAlign.End,
			lineHeight = 60.sp,
			modifier = Modifier
				.fillMaxWidth()
				.padding(24.dp)
		)
		LazyVerticalGrid(
			columns = GridCells.Fixed(4),
			verticalArrangement = Arrangement.Bottom,
			modifier = Modifier
				.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 25.dp)
				.fillMaxSize(),
		) {
			// Function Row

			item {
				// Button (
				Button(
					onClick = {
						if (text == "0") {
							text = "("
						} else {
							text += "("
						}
					}, colors = ButtonDefaults.buttonColors(Color(0xFFDCD429)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp), shape = CircleShape

				) {
					Text(text = "(", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)

				}
			}
			item {
				// Button )
				Button(
					onClick = {
						if (text == "0") {
							text = ")"
						} else {
							text += ")"
						}
					}, colors = ButtonDefaults.buttonColors(Color(0xFFDCD429)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp), shape = CircleShape

				) {
					Text(text = ")", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)

				}
			}
			item {
				// Button AC
				Button(
					onClick = {
						text = "0"
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFDCD429)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp), shape = CircleShape

				) {
					Text(text = "AC", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)

				}
			}
			item {
				// Button c
				Button(
					onClick = {
						if (text.isNotEmpty()) {
							text = text.dropLast(1)
						}
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFEB882D)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp), shape = CircleShape

				) {
					Text(text = "C", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)

				}
			}

			// First Row
			item {
				// Button 1
				Button(
					onClick = {
						if (text == "0") {
							text = "1"
						} else {
							text += "1"
						}
					}, modifier = Modifier
						.padding(8.dp)
						.size(78.dp), shape = CircleShape

				) {
					Text(text = "1", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)

				}
			}
			// Button 2
			item {
				Button(
					onClick = {
						if (text == "0") {
							text = "2"
						} else {
							text += "2"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "2", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button 3
			item {
				Button(
					onClick = {
						if (text == "0") {
							text = "3"
						} else {
							text += "3"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "3", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button +
			item {
				Button(
					onClick = {

						val lastOperatorIndex = text.lastIndexOfAny(charArrayOf('+', '-', '*', '/'))
						val lastDecimalIndex = text.lastIndexOf('.')
						text += if (lastOperatorIndex > lastDecimalIndex) {
							"+"
						} else  {
							"+"
						}
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFEB882D)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape


				) {
					Text(text = "+", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}

			// Second row
			item {
				// Button 4
				Button(
					onClick = {
						if (text == "0") {
							text = "4"
						} else {
							text += "4"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape
				) {
					Text(text = "4", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button 5
			item {
				Button(
					onClick = {
						if (text == "0") {
							text = "5"
						} else {
							text += "5"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "5", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button 6
			item {
				Button(
					onClick = {
						if (text == "0") {
							text = "6"
						} else {
							text += "6"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "6", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button -
			item {
				Button(
					onClick = {
						val lastOperatorIndex = text.lastIndexOfAny(charArrayOf('+', '-', '*', '/'))
						val lastDecimalIndex = text.lastIndexOf('.')
						text += if (lastOperatorIndex > lastDecimalIndex) {
							"-"
						} else  {
							"-"
						}
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFEB882D)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape


				) {
					Text(text = "-", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}

			//Third Row
			item {
				// Button 7
				Button(
					onClick = {
						if (text == "0") {
							text = "7"
						} else {
							text += "7"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape
				) {
					Text(text = "7", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button 8
			item {
				Button(
					onClick = {
						if (text == "0") {
							text = "8"
						} else {
							text += "8"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "8", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button 9
			item {
				Button(
					onClick = {
						if (text == "0") {
							text = "9"
						} else {
							text += "9"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "9", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button *
			item {
				Button(
					onClick = {
						val lastOperatorIndex = text.lastIndexOfAny(charArrayOf('+', '-', '*', '/'))
						val lastDecimalIndex = text.lastIndexOf('.')
						text += if (lastOperatorIndex > lastDecimalIndex) {
							"*"
						} else  {
							"*"
						}
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFEB882D)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape


				) {
					Text(text = "*", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Fourth Row
			item {
				// Button .
				Button(
					onClick = {
						val lastOperatorIndex = text.lastIndexOfAny(charArrayOf('+', '-', '*', '/'))
						val lastDecimalIndex = text.lastIndexOf('.')
						if (lastOperatorIndex > lastDecimalIndex) {
							text += "."
						} else if (lastDecimalIndex == -1) {
							text += "."
						}

					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape
				) {
					Text(text = ".", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button 0
			item {
				Button(
					onClick = {
						val lastChar = text.lastOrNull()
						if (lastChar != '0') {
							text += "0"
						}
					},
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "0", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button .
			item {
				Button(
					onClick = {
						val expression = Expression(text)
						val result = expression.calculate()
						text = result.toString()
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFDCD429)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(text = "=", fontSize = 32.sp, fontFamily = FontFamily.SansSerif)
				}
			}
			// Button =
			item {
				Button(
					onClick = {
						val lastOperatorIndex = text.lastIndexOfAny(charArrayOf('+', '-', '*', '/'))
						val lastDecimalIndex = text.lastIndexOf('.')
						text += if (lastOperatorIndex > lastDecimalIndex) {
							"/"
						} else  {
							"/"
						}
					},
					colors = ButtonDefaults.buttonColors(Color(0xFFFF9800)),
					modifier = Modifier
						.padding(8.dp)
						.size(78.dp),
					shape = CircleShape

				) {
					Text(
						text = "/", fontSize = 32.sp, fontFamily = FontFamily.SansSerif
					)
				}
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
	CalculatorAppTheme {

		FinalApp()
	}
}
