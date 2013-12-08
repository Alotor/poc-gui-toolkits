import java.awt.Color
import java.awt.Font

import org.apache.pivot.collections.*
import org.apache.pivot.wtk.*

class Main implements Application {
    def window = null

    @Override
    public void startup(Display display, Map<String, String> properties) {
        def label = new Label()
        label.text = "Hello world"
        label.styles.put("font", new Font("Arial", Font.BOLD, 24))
        label.styles.put("color", Color.RED)
        label.styles.put("horizontalAlignment", HorizontalAlignment.CENTER)
        label.styles.put("verticalAlignment", VerticalAlignment.CENTER)

        window = new Window()
        window.content = label
        window.title = "Hello world"
        window.maximized = true
        window.open(display)
    }

    @Override
    public boolean shutdown(boolean optional) {
        window?.close()
        return false
    }

    @Override
    public void suspend() {
    }

    @Override
    public void resume() {
    }

    public static void main(String[] args) {
        DesktopApplicationContext.main(Main.class, args)
    }
}
