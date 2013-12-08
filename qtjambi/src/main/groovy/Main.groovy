import com.trolltech.qt.gui.*

class Main extends QWidget {
    static void main(args) {
        QApplication.initialize(args)
        def helloButton = new QPushButton("Hello world!")
        helloButton.resize(120, 40)
        helloButton.windowTitle = "Hello world"
        helloButton.show()

        QApplication.exec()
    }
}
