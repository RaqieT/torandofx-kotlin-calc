package pl.politechnika.lodzka.michalowskid.calc.torando.fx

import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.px

class CalcStylesheet : Stylesheet() {
    init {
        text {
            padding = box(5.px)
            fontSize = 25.px
        }
        textField {
            padding = box(10.px)
            minWidth = 100.px
            prefWidth = 200.px
            minHeight = 50.px
            prefHeight = 50.px
        }
        button {
            minWidth = 50.px
            prefWidth = 50.px
            minHeight = 50.px
            prefHeight = 50.px
        }
    }
}