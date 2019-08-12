public class InteractRunner {


	public static void main(String[] args) {

        InteractMenu intMenu = new InteractMenu();


        while (!intMenu.getIsClosed()) {
            intMenu.startDialog();
            intMenu.conductOperations(intMenu.getArgs());
        }
	}
}
