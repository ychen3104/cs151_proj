

import java.awt.BorderLayout;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class CalendarController extends JPanel{
	private SelectedView selectedView;
	private MonthView month;
	private MyCalendar mc;
	
	public CalendarController(MyCalendar myc) {
		this.mc = myc;
		month = new MonthView(mc);
		selectedView = new SelectedView(mc.getCalendar(), mc.getEventSet());
		
		this.setLayout(new BorderLayout());
		this.add(month,BorderLayout.WEST);
		this.add(selectedView,BorderLayout.EAST);
	}
	
	public void modify() {
		selectedView.printDayView(mc.getCalendar());
	}
	
	public void changeDate(GregorianCalendar c) {
		month.printMonthlyCalendar(c);
		selectedView.printView(c);
	}
	
	public void changeView(GregorianCalendar c, int n) {
		selectedView.printView(c, n);
	}
	
	public void agendaView(Date f, Date t) {
		selectedView.printAgendaView(f, t);
	}
	
}
