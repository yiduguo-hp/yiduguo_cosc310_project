package assignment2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * everything displayed on Screen is within contents
 * constructor takes width and height
 */

public class Contents extends JLabel{
	public Contents(int w, int h) {
		
		setPreferredSize(new Dimension(w, h));
		setMaximumSize(new Dimension(w,h));
		setMinimumSize(new Dimension(w,h));
		setBackground(Color.LIGHT_GRAY);
		setOpaque(true);
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
		setBorder(border);
		
		Font f = new Font("#PilGi", Font.BOLD, 16);
		
		JTextField input = new JTextField();
		input.setBounds(w/4, 3*h/4, 2*w/4, 100);
		
		
		OutputTerminal  output= new OutputTerminal();
		output.setFont(f);
		
		JScrollPane scroller = new JScrollPane(output);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);  
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroller.setBounds(w/4, h/8, 2*w/4, 2*h/4);
		
		JButton button = new JButton("ASK!");
		button.addActionListener(e -> {
			output.askQuestion(input.getText());
			input.setText("");
		});
		button.setFont(f);
		button.setSize(100, 100);
		button.setBounds(3*w/4 + 10, 3*h/4, 100, 100);
		button.setBackground(Color.white);
		
		add(scroller);
		add(button);
		add(input);
		updateUI();
	}

}