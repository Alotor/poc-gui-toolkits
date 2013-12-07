import org.eclipse.swt.*
import org.eclipse.swt.widgets.*
import org.eclipse.swt.layout.*
import org.eclipse.swt.custom.*
import org.eclipse.swt.events.*

class Main {
    static void main(args) {
        try {
            new Main().start()
        } catch(Exception e) {
            e.printStackTrace()
            System.exit(-1)
        }
    }

    def display
    def shell

    Main() {
        display = new Display()
        shell = new Shell(display)
    }

    def start() {
        shell.setLayout(new GridLayout())
        initUI()

        shell.maximized = true
        shell.open()

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep()
            }
        }
    }

    def initUI() {
        initMenu()
        initTabs()
    }

    def initMenu() {
        def menuBar = new Menu(shell, SWT.BAR)

        def menuBarItem = new MenuItem(menuBar, SWT.CASCADE)
        menuBarItem.text = "File"
        initFileMenu(menuBarItem)

        menuBarItem = new MenuItem(menuBar, SWT.CASCADE)
        menuBarItem.text = "A menu"
        initMockMenu(menuBarItem)

        menuBarItem = new MenuItem(menuBar, SWT.CASCADE)
        menuBarItem.text = "Other menu"
        initMockMenu(menuBarItem)

        menuBarItem = new MenuItem(menuBar, SWT.CASCADE)
        menuBarItem.text = "Configuration"
        initMockMenu(menuBarItem)

        shell.setMenuBar(menuBar)
    }

    def initFileMenu(menuBarItem) {
        def menu = new Menu(shell, SWT.DROP_DOWN)
        menuBarItem.menu = menu

        def item = new MenuItem(menu, SWT.PUSH)
        item.text = "New"

        item = new MenuItem(menu, SWT.PUSH)

        item.text = "Exit"

        item.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event) {
                shell.getDisplay().dispose()
                System.exit(0)
            }
        })
    }

    def initMockMenu(menuBarItem) {
        def menu = new Menu(shell, SWT.DROP_DOWN)
        menuBarItem.menu = menu

        5.times {
            def item = new MenuItem(menu, SWT.PUSH)
            item.text = "Option$it"
        }
    }

    def initTabs() {
        def tabFolder = new CTabFolder(shell, SWT.TOP)
        def gridData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1)
        tabFolder.setLayoutData(gridData)

        def tab = new CTabItem(tabFolder, SWT.NONE)
        tab.text = "Intro"

        tab = new CTabItem(tabFolder, SWT.NONE)
        tab.text = "Screen A"

        tab = new CTabItem(tabFolder, SWT.NONE)
        tab.text = "Screen B"

        tab = new CTabItem(tabFolder, SWT.NONE)
        tab.text = "Options"
    }
}
