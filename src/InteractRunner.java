/**
 * Class Класс запускающий всю программу.
 * @author Kovalev
 * @since 13.08.2019
 * @version 1
 */
public class InteractRunner {

	public static void main(String[] args) {

        InteractMenu intMenu = new InteractMenu();


        while (!intMenu.getIsClosed()) {
            intMenu.startDialog();
            intMenu.conductOperations(intMenu.getArgs());
        }
	}
}
