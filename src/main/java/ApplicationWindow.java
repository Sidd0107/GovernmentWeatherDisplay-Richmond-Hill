

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class ApplicationWindow {

	private JFrame frame;
	private JTextField txtWeather;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 153, 51));
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Government Weather Monitor Richmond Hill\n");
		lblWelcomeToThe.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblWelcomeToThe.setForeground(new Color(255, 255, 255));
		lblWelcomeToThe.setBackground(Color.DARK_GRAY);
		lblWelcomeToThe.setBounds(40, 48, 367, 47);
		frame.getContentPane().add(lblWelcomeToThe);
		
		txtWeather = new JTextField();
		txtWeather.setFont(new Font("Charlemagne Std", Font.BOLD, 20));
		txtWeather.setForeground(Color.WHITE);
		txtWeather.setHorizontalAlignment(SwingConstants.CENTER);
		txtWeather.setText("WEATHER");
		txtWeather.setBackground(Color.BLACK);
		txtWeather.setBounds(0, 0, 450, 54);
		frame.getContentPane().add(txtWeather);
		txtWeather.setColumns(10);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(50, 121, 425, 202);
		frame.getContentPane().add(textArea);
		
		JButton btnGetLatestWeather = new JButton("Get Latest Weather Details");
		btnGetLatestWeather.setBounds(40, 386, 203, 47);
		btnGetLatestWeather.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = App.getWeather();
				
				textArea.setLineWrap(true);
		        textArea.setWrapStyleWord(true);
		        
		        Border border = BorderFactory.createLineBorder(Color.BLACK);
		        textArea.setBorder(BorderFactory.createCompoundBorder(border, 
		                    BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		      
		        textArea.setEditable(false);
		        UIManager.put("TextArea.margin", new Insets(20,20,20,20));
				textArea.setText(result);
			}
		});
		frame.getContentPane().add(btnGetLatestWeather);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		btnClear.setBounds(333, 385, 117, 49);
		frame.getContentPane().add(btnClear);
		
		
	}
}
