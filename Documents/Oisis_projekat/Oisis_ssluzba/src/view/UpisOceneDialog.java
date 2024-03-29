package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import controller.DocumentListenerUpis;
import controller.StudentController;
import model.BazaStudenata;
import model.Predmet;
/**
 * This class implements a dialog which is used for adding a grade
 * from the list of not passed subjects which selected student has.
 * 
 * @author Aleksa Papovic
 *
 */	
public class UpisOceneDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * This is a static combo box for a grade.
	 */
	public static JComboBox<String> comboboxUpisa;
	/**
	 *   This is a static button to confirm the grade entry.
	 */
	public static JButton prihvatiUpis;
	/**
	 * This is a static text field which is the date when a grade has made.
	 */
	public static JTextField datumUpisaField;
	private DocumentListener docUpis = new DocumentListenerUpis();

	/**
	 * Constructor with parameters where the dialog is initialized and his
	 * dimensions and tabs are set.
	 * 
	 * @param parent the window which the dialog is relative to
	 * @param title  the name of the dialog
	 * @param modal  boolean value which tells us if we have to finish working with
	 *               this dialog to switch to other windows or not
	 */
	public UpisOceneDialog(JDialog parent, String title, boolean modal) {
		super(parent, title, modal);
		setTitle(title);
		setSize(450, 300);
		setLocationRelativeTo(parent);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel textPanel = new JPanel(new GridLayout(4, 1, 1, 10));
		JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 20));

		textPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		Dimension polje = new Dimension(100, 30);

		ArrayList<Predmet> p = BazaStudenata.getInstance().getStudenti()
				.get(TabsPanel.tableStudent.getSelectedTableRow()).getNepolozeniIsp();

		Predmet predmet = p.get(IzmenaStudentaTabs.tableNepolozeniPredmeti.getSelectedRow());
		JLabel sifraPredmetaLabela = new JLabel("Šifra predmeta");
		sifraPredmetaLabela.setPreferredSize(polje);
		sifraPredmetaLabela.setMaximumSize(polje);
		JTextField sifraPredmetaField = new JTextField();
		sifraPredmetaField.setText(predmet.getSifraP());
		sifraPredmetaField.setEnabled(false);

		JLabel imePredmetaLabela = new JLabel("Unesite prezime");
		imePredmetaLabela.setPreferredSize(polje);
		imePredmetaLabela.setMaximumSize(polje);
		JTextField imePredmetaField = new JTextField();
		imePredmetaField.setText(predmet.getImeP());
		imePredmetaField.setEnabled(false);

		JLabel datumUpisaLabela = new JLabel("Unesite datum rodjenja");
		datumUpisaLabela.setPreferredSize(polje);
		datumUpisaLabela.setMaximumSize(polje);
		datumUpisaField = new JTextField();

		JLabel ocenaLabela = new JLabel("Ocena");
		ocenaLabela.setPreferredSize(polje);
		ocenaLabela.setMaximumSize(polje);

		JLabel titulaLabela = new JLabel("Izaberite titulu");
		titulaLabela.setPreferredSize(polje);
		titulaLabela.setMaximumSize(polje);
		String ocene[] = { "6", "7", "8", "9", "10" };
		comboboxUpisa = new JComboBox<String>(ocene);

		prihvatiUpis = new JButton("Potvrdi");
		prihvatiUpis.setPreferredSize(polje);
		prihvatiUpis.setEnabled(false);
		JButton odbaci = new JButton("Odustani");
		odbaci.setPreferredSize(polje);

		prihvatiUpis.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (StudentController.getInstance().upisi(predmet.getSifraP(), predmet.getImeP(),
						comboboxUpisa.getSelectedIndex() + 6, datumUpisaField.getText()))
					dispose();

			}
		});

		odbaci.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		datumUpisaField.getDocument().addDocumentListener(docUpis);
		add(panel);

		panel.add(textPanel, BorderLayout.NORTH);
		panel.add(buttonsPanel, BorderLayout.CENTER);

		textPanel.add(sifraPredmetaLabela);
		textPanel.add(sifraPredmetaField);
		textPanel.add(imePredmetaLabela);
		textPanel.add(imePredmetaField);
		textPanel.add(ocenaLabela);
		textPanel.add(comboboxUpisa);
		textPanel.add(datumUpisaLabela);
		textPanel.add(datumUpisaField);

		buttonsPanel.add(prihvatiUpis);
		buttonsPanel.add(odbaci);

		setVisible(true);
	}
}
