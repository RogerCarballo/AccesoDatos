package serializacion;

public class Administrador extends Empleado {
	private double incentivo;
	
	public Administrador(String n,double s,int agno, int mes, int dia) {
		
		super(n,s,agno,mes,dia);
		incentivo = 0;
	}
	
	@Override
	public double getSueldo() {
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " Incentivo= " + incentivo;
	}
	
	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}
	
}
