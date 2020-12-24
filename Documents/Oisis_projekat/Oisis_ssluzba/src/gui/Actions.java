/*REFERENCA:https://alvinalexander.com/java/java-action-abstractaction-actionlistener/*/

package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Actions {
	public String tekst = "<html>Glavni prozor se sastoji iz Menubar-a, Toolbar-a, Statusbar-a, Searchbar-a u Toolbar-u i centralnog prozora <br>"
			+ "koji prikazuje studente, profesore i predmete. Meniji koji postoje u Menubar-u su File, Edit i Help. File sadrzi stavke <br>"
			+ "New, koja pravi novi entitet i Close, koja zatvara aplikaciju. Edit sadrzi stavke Edit, koja sluzi za menjanje podataka entiteta i<br>"
			+ "i Delete, koja brise postojeci entitet. Help meni sadrzi Help stavku, koja sluzi za pomoc korisniku, i<br>"
			+ "About stavku, koja sluzi za prikaz verzije aplikacije, kao i kratak opis iste.</html>";

	public Actions() {

	}

	public class NewAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 4444373563346796488L;

		public NewAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			DodavanjeProfesoraDialog dialogNoviProfesor = new DodavanjeProfesoraDialog(MainFrame.getInstance(),
					"Dodavanje Profesora", true);
			dialogNoviProfesor.setVisible(true);
			switch (TabsPanel.tab_curr) {
			case 0: {
				DodavanjeStudentaDialog dialogNoviStudent = new DodavanjeStudentaDialog(MainFrame.getInstance(),
						"Dodavanje Studenta", true);
				dialogNoviStudent.setVisible(true);
			}
				break;

			default:
				break;
			}
		}
	}

	public class CloseAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 23685682457822238L;

		public CloseAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Would have done the 'Close' action.");
		}
	}

	public class EditAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5247903053441802302L;

		public EditAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {

		}
	}

	public class DeleteAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7769040185540318009L;

		public DeleteAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Would have done the 'Delete' action.");
		}
	}

	public class HelpAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1374658992717206617L;

		public HelpAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			HelpDialog dialog = new HelpDialog(MainFrame.getInstance(), "Help", true);
			dialog.setVisible(true);
		}
	}

	public class AboutAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9021628910874527061L;

		public AboutAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			AboutDialog dialog = new AboutDialog(MainFrame.getInstance(), "About", true);
			dialog.setVisible(true);
		}
	}

	public class SearchAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7769040185540318009L;

		public SearchAction(String name, ImageIcon icon, String shortDescription, Integer mnemonic,
				KeyStroke accelerator) {
			super();
			putValue(SHORT_DESCRIPTION, shortDescription);
			putValue(MNEMONIC_KEY, mnemonic);
			putValue(ACCELERATOR_KEY, accelerator);
			putValue(SMALL_ICON, setAbstractAction(icon));
		}

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Would have done the 'Search' action.");
		}
	}

	private ImageIcon setAbstractAction(ImageIcon icon) {
		Image img = icon.getImage();
		Image newimg3 = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
		icon = new ImageIcon(newimg3);
		return icon;
	}

}
