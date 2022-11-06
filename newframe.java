import javax.swing.*;

public class newframe extends JFrame {

	public static void main(String[] args) {
		newframe frameTabel = new newframe();
	}

	JLabel welcome = new JLabel("Welcome to Roseindia.net");
	JPanel panel = new JPanel();

	newframe() 
	{
		  setSize(300, 200);
		  setLocation(500, 280);
		  panel.setLayout(null);

		welcome.setBounds(70, 50, 150, 60);

		panel.add(welcome);

		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}