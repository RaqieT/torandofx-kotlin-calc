package pl.politechnika.lodzka.michalowskid.calc.torando.fx

import javafx.scene.control.Button
import javafx.scene.control.TextField
import tornadofx.*
import java.lang.Exception

class MainView: View("Calc") {

    var calcField: TextField by singleAssign()
    var rpn: ReversePolishNotationImpl = ReversePolishNotationImpl()

    override val root = vbox {
        hbox {
            calcField = textfield()
        }

        hbox {
            button {
                text = "7"
            }
            button {
                text = "8"
            }
            button {
                text = "9"
            }
            button {
                text = "x"
            }
        }
        hbox {
            button {
                text = "4"
            }
            button {
                text = "5"
            }
            button {
                text = "6"
            }
            button {
                text = "-"
            }
        }
        hbox {
            button {
                text = "1"
            }
            button {
                text = "2"
            }
            button {
                text = "3"
            }
            button {
                text = "+"
            }
        }

        hbox {
            button {
                text = "C"
            }
            button {
                text = "0"
            }
            button {
                text = "/"
            }
            button {
                text = "="
            }
        }
    }

    init {
        root.lookupAll(".button").forEach { button ->
            button.setOnMouseClicked {
                addInput((button as Button).text)
            }
        }
    }

    private fun addInput(inputLabel: String) {
        if (calcField.text.startsWith("=")) {
            calcField.text = ""
        }

        if (inputLabel == "C") {
            calcField.text = ""
            return
        }

        calcField.text += inputLabel

        if (inputLabel == "=") {
            try {
                val res = rpn.calculate(calcField.text)
                calcField.text = "=$res"

            } catch (e : Exception) {
                calcField.text = "Something went wrong"
                return
            }
            return
        }
    }
}
