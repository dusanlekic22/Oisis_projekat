package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.StudentController;
/**
 * This class implements templates for the text fields which are used for
 * checking the validity of text fields for a student.
 * 
 * @author Dusan Lekic
 *
 */
public class StudentTextFields extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TipPolja {
		Ime, Prezime, DatumR, AdresaS, BrojTel, Email, BrojInd, GodUp
	};

	private JTextField polje;
	private TipPolja tip;
	private String sablon;
	/**
	 * Returns the template of the field.
	 * @return template of the field
	 */
	public String getSablon() {
		return sablon;
	}
	/**
	 * Constructor with parameters which initializes the fields, checks the validity
	 * of the fields and sets templates.
	 * 
	 * @param tipPolja type of the field
	 * @param sablonPolja template of the field
	 */
	public StudentTextFields(TipPolja tipPolja, String sablonPolja) {
		polje = this;
		this.tip = tipPolja;
		this.sablon = sablonPolja;
		this.setText(sablonPolja);
		this.setForeground(new Color(200, 200, 200));

		this.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent fe) {
				// TODO Auto-generated method stub
				if (!proveraPolja() || polje.getText().trim().equals(sablonPolja)
						|| polje.getText().trim().isEmpty() == true) {
					if (!polje.getText().trim().equals(sablonPolja) && !polje.getText().trim().isEmpty() == true) {
						JOptionPane.showMessageDialog(null, "Unesite u formatu " + sablonPolja, "Greška",
								JOptionPane.ERROR_MESSAGE);
					}
					polje.setForeground(new Color(200, 200, 200));
					polje.setText(sablonPolja);
				}

			}

			@Override
			public void focusGained(FocusEvent fe) {
				// TODO Auto-generated method stub
				polje.setForeground(Color.BLACK);
				if (polje.getText().trim().equals(sablonPolja)) {
					polje.setText("");
				}
			}
		});
	}
	/**
	 * This method checks for the validity of the text fields
	 * @return true or false depending on the validity of the text fields
	 */
	public boolean proveraPolja() {
		switch (tip) {
		case Ime:
			return StudentController.getInstance().proveriIme(polje.getText().trim());
		case Prezime:
			return StudentController.getInstance().proveriIme(polje.getText().trim());
		case DatumR:
			return StudentController.getInstance().proveriDatumR(polje.getText().trim());
		case AdresaS:
			return StudentController.getInstance().proveriAdresuSt(polje.getText().trim());
		case BrojTel:
			return StudentController.getInstance().proveriKontaktTl(polje.getText().trim());
		case Email:
			return StudentController.getInstance().proveriEmail(polje.getText().trim());
		case BrojInd:
			return StudentController.getInstance().proveriBrojInd(polje.getText().trim());
		case GodUp:
			return StudentController.getInstance().proveriGodUp(polje.getText().trim());
		default:
			return false;
		}
	}
}
