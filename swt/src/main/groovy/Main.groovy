import org.eclipse.swt.*
import org.eclipse.swt.widgets.*
import org.eclipse.swt.layout.*

class Main {
    static void main(String[] args) {
        def display = new Display()
        def shell = new Shell(display)
        shell.text = "Hello world"

        def layout = new FillLayout()
        layout.type = SWT.VERTICAL
        shell.layout = layout

        def label = new Label(shell, SWT.CENTER);
        label.text = "Hola mundo"

        shell.open()

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep()
            }
        }
    }
}
