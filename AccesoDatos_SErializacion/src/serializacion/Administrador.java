package serializacion;

public class Administrador extends Empleado {
	
	//Atributos
	private double incentivo;
	
	//constructores
	public Administrador(String n,double s,int agno, int mes, int dia) {
		
		super(n,s,agno,mes,dia);
		incentivo = 0;
	}
	
	//getters
	@Override
	public double getSueldo() {
		double sueldoBase = super.getSueldo();
		return sueldoBase + incentivo;
	}
	
	//toString
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " Incentivo= " + incentivo;
	}
	
	//setters
	public void setIncentivo(double incentivo) {
		this.incentivo = incentivo;
	}
	
}
