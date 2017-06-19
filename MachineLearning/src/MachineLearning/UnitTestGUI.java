package MachineLearning;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UnitTestGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnitTestGUI window = new UnitTestGUI();
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
	public UnitTestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.  
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 599, 748);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAlgorithms = new JMenu("Learning Algorithm");
		menuBar.add(mnAlgorithms);
		
		JMenuItem mntmBackProp = new JMenuItem("Back Propagation");
		mntmBackProp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BackPropTest test = new BackPropTest();
				test.RunTest();
			}
		});
		mnAlgorithms.add(mntmBackProp);
		
		JMenuItem mntmLSTM = new JMenuItem("LSTM");
		mnAlgorithms.add(mntmLSTM);
		
		JMenuItem mntmForestTrees = new JMenuItem("Forest Trees");
		mnAlgorithms.add(mntmForestTrees);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});


		mnAlgorithms.add(mntmQuit);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}

}
