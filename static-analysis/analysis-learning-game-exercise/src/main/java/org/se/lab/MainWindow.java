package org.se.lab;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.SwingConstants;

public class MainWindow {
	int cheats = 0;
	int magicCheatNumber = 3;
	private JFrame frmGewaltentrennung;
	private JTable table;
	private DataSource dataSource;
	private static Random myRandom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.out.println("Guten Tag!");
		System.out.println("Wenn du das liest, bist du auserw�hlt, den Cheatmodus in diesem Programm zu benutzen :D");
		System.out.println("Undzwar: du musst im Programm in den Editiermodus eines Items gehen.");
		System.out.println("Jetzt dr�ckst du die ALT Taste 3-4 Mal, jedenfalls so oft bis die Caps Lock Lampe auf der Tastatur f�r 100 ms aufleuchtet.");
		System.out.println("Deaktiviert wird der Cheat Modus mit der Strg Taste. Dass dies passiert ist, wird �ber 2x blinken von caps lock angezeigt.");
		
		
		myRandom = new Random(System.currentTimeMillis());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmGewaltentrennung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	    try {
	        // Set System L&F
	        UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
	    } catch (Exception ex){
	    	
	    }
		
		frmGewaltentrennung = new JFrame();
		frmGewaltentrennung.setTitle("Gewaltentrennung V2.0 Beta 1");
		frmGewaltentrennung.setBounds(100, 100, 789, 599);
		frmGewaltentrennung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		
		final JButton btnNewButton = new JButton("Neu mischen");
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				randomRefresh();				
			}
		});
	
		final JSpinner spinner = new JSpinner();
		
		JLabel lblNewLabel = new JLabel("Textgr\u00F6\u00DFe:");
		
		JLabel lblNewLabel_1 = new JLabel("\u00A92013 Anonymized");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout groupLayout = new GroupLayout(frmGewaltentrennung.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(10)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 773, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel)
							.addComponent(lblNewLabel_1))
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		frmGewaltentrennung.getContentPane().setLayout(groupLayout);
		
		spinner.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent arg0) {
				table.setFont(new Font("Arial",0, (Integer) spinner.getValue()));
				Integer intval = (Integer)spinner.getValue();
				table.setRowHeight((int) ((double)intval * 1.3));
			}
		});
		
		table.setFont(new Font("Arial",0, 20));
		spinner.setValue(20);
		
		Integer intval = (Integer)spinner.getValue();
		table.setRowHeight((int) ((double)intval * 1.3));
		
		this.dataSource = new DataSource();
		randomRefresh();
		
		table.setDefaultRenderer(MultiDataCell.class, new MyRenderer());
		table.setDefaultEditor(MultiDataCell.class, new MyTableCellEditor(new JTextField()));
	}
	
	class MyTableCellEditor extends DefaultCellEditor
	{
		public MyTableCellEditor(JTextField name) {
			super(name);
			// TODO Auto-generated constructor stub
		}

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellEditorComponent(
		        JTable table,
		        Object value,
		        boolean isSelected,
		        int row,
		        int column)
		{
			final MultiDataCell cell = ((MultiDataCell) value);
		    final JTextField c = (JTextField) super.getTableCellEditorComponent(table, ((MultiDataCell) value).toString(), // edit the text field of Cell
		    	isSelected,
		        row,
		        column);
		    
		    for( KeyListener al : c.getKeyListeners() ) {
		        c.removeKeyListener( al );
		    }
		    
		    c.setFont(table.getFont());
		    
		    c.addKeyListener(new KeyListener() {

		    	void cheatDetectionRoutine(KeyEvent arg0){
		    		if (arg0.getKeyCode() == KeyEvent.VK_ALT) {
		    			
						cheats++;
						
						if (cheats >= magicCheatNumber) {
							System.out.println("Cheats aktiviert :D");
							
							Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
						}
					}
					if (arg0.getKeyCode() == KeyEvent.VK_CONTROL && cheats >= magicCheatNumber) {
						System.out.println("Cheats deaktiviert :(");
						cheats = 0;
						
						try {
							Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
							Thread.sleep(100);
							Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
							Thread.sleep(100);
							Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, true);
							Thread.sleep(100);
							Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_CAPS_LOCK, false);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
		    	}
		    	
		    	public void cheatRoutine(KeyEvent arg0){
		    		if (cheats >= magicCheatNumber){
		    				if (c.getSelectionStart() < cell.getDisplayedText().length())
		    					arg0.setKeyChar(cell.getDisplayedText().charAt(c.getSelectionStart()));
		    				else
		    					arg0.setKeyCode(0);
		    		}
		    	}
		    	
				@Override
				public void keyTyped(KeyEvent arg0) {
					cheatRoutine(arg0);
				}
				
				@Override
				public void keyReleased(KeyEvent arg0) {
					cheatDetectionRoutine(arg0);
				}
				
				@Override
				public void keyPressed(KeyEvent arg0) {
					
					
				}
			});
		    c.selectAll(); // automatically select the whole string in the cell
		    return c;
		}
	}

    private static class MyRenderer extends DefaultTableCellRenderer {

        Color backgroundColor = getBackground();

        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (value instanceof MultiDataCell){
            	c.setBackground(((MultiDataCell)value).getBackgroundColor());
            }
            c.setForeground(Color.black);
            return c;
        }
    }
	
	private void randomRefresh() {
		dataSource.randomize();		
		table.setModel(new TableModel() {
			
			public void setValueAt(Object value, int arg1, int arg2) {
				dataSource.setUserData((String)value,arg1,arg2);
			}
			
			public void removeTableModelListener(TableModelListener arg0) {}
			
			public boolean isCellEditable(int row, int col) {
				return dataSource.isCellEditable(row,col);
			}
			
			public Object getValueAt(int row, int col) {
				return dataSource.getDataAt(row,col);
			}
			
			public int getRowCount() {
				return dataSource.getRowCount();
			}
			
			public String getColumnName(int arg0) {
				return null;
			}
			
			public int getColumnCount() {
				return dataSource.getColumnCount();
			}
			
			public Class<MultiDataCell> getColumnClass(int arg0) {
				return MultiDataCell.class;
			}
			
			public void addTableModelListener(TableModelListener arg0) {}
		});
	}

	public static Random getRandom() {
		return myRandom;
	}
}
