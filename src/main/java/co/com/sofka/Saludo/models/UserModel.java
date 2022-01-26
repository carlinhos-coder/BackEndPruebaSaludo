package co.com.sofka.Saludo.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UserModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    
    


    public UserModel(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserModel() {
	
	}

	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

