package DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DAO <T>{
	BDD db = new BDD();
	public DAO() throws SQLException{
		db.connection();
	}
	/**
	 * Sauvegarder une forme dans la BDD.
	 * @param obj forme
	 * @return forme créée
	 */
	public abstract T create(T obj);
	
	/**
	 * récupérer un objet dans la BDD à partir de son nom.
	 * @param nom nom de l'objet à récupérer
	 * @return objet récupéré
	 */
	public abstract T read(String nom);
	
	/**
	 * MAJ dans la BDD d'une forme.
	 * @param obj forme
	 * @return obj
	 */
	public abstract T update(T obj);
	
	/**
	 * supression d'objet de la BDD
	 * @param obj objet à supprimer de la BDD
	 */
	public abstract void delete(T obj);
	
	/**
	 * initialisation de l'objet
	 * @return
	 */
	public abstract ArrayList<?> init();
}
