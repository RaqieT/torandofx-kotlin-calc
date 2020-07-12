package pl.politechnika.lodzka.michalowskid.calc.torando.fx
import javafx.stage.Stage
import tornadofx.App
import tornadofx.launch

class MainApp: App(MainView::class, CalcStylesheet::class) {
    override fun start(stage: Stage) {
        stage.isResizable = false
        super.start(stage)
    }
}

fun main(args: Array<String>) {
    launch<MainApp>(args)
}
