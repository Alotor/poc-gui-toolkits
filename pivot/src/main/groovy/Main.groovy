import java.awt.Color
import java.awt.Font

import org.apache.pivot.beans.*
import org.apache.pivot.collections.*
import org.apache.pivot.wtk.*

class Main implements Application {
    def window = null

    @Override
    public void startup(Display display, Map<String, String> properties) {
        def serializer = new BXMLSerializer()
        window = serializer.readObject(Main.class, "Main.bxml") as Window
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
