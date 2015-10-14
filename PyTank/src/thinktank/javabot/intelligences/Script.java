package thinktank.javabot.intelligences;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import thinktank.javabot.graphics.GraphicInterface;
import thinktank.javabot.physics.Tank;


/**
* @author Gabriel
*/
public class Script {

//=============================================================================
// Attributs
	
	private String m_instructions = "";
	private String m_filename;
	private int m_currentLine = 0;
	private String m_tmpfile_name;
	private String  m_tmpfile_content = "";
	private Intelligence m_intelligence;


//=============================================================================
// Méthodes publiques
	
	/**
     * Constructeur dépendant d'un nom de fichier et d'une intelligence.
     * @param filename nom du fichier script à charger
     * @param intelligence 
     */
	public Script(String filename, Intelligence intelligence)
	{
		
		m_filename = filename;
		m_intelligence = intelligence;
		importInstructionsFromFile(this.m_filename);
		m_tmpfile_name = generateRandomFilename();
		writeTmpFile();
	}

	/**
	 * Mutateur du nom de fichier du script
	 * 
	 * @param filename nouveau nom de fichier
	 */
	public void setFileName(String filename)
	{
		m_filename = filename;
		m_instructions = "";
		importInstructionsFromFile(m_filename);
		writeTmpFile();
		updateInstructions(m_instructions);
	}
	
	public String getInstructions()
	/**
     * Récupère les instructions du fichier de script
     * @return instructions
     */
	{
		return m_instructions;
	}
	
	public void setCurrentLine(int line)
	/**
     * Attribue la ligne en cours
     * @param line
     */
	{
		m_currentLine = line;
	}
	
	public int getCurrentLine()
	/**
     * Retourne la ligne en cours
     * @return currentLine
     */
	{
		return m_currentLine;
	}
	
	public String getTmpFileName()
	/**
     * Retourne le nom du fichier temporaire du script
     * @return tmpFileName
     */
	{
		return m_tmpfile_name;
	}
	
	public int startPositionLine(int line)
	
	/**
	 * Retourne la position du premier caractère de la ligne à mettre en surbrillance
     * @param line
     * @return line number, 
     */	
	{
		int i = 0;
		String[] lines = m_instructions.split("\n");
		try
		{
			for (int j = 0; j < line - 1; j++)
			{
				i += lines[j].length() + 1;
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return 0;
		}
		
		return i;
	}
	
	public int endPositionLine(int line)
	
	/**
     * Retourne la position du dernier caractère de la ligne à mettre en surbrillance
     * @param line
     * @return line number
     */	
	{
		int i = 0;
		String[] lines = m_instructions.split("\n");
		try
		{
			for (int j = 0; j < line ; j++)
			{
				i += lines[j].length() + 1;
			}
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return 0;
		}
		
		return i;
	}
	
	public void updateInstructions(String newInstructions)
	/**
     * Applique la surcouche au script Python
     * @param newInstructions
     */	
	{
		
		m_instructions = newInstructions;
		m_tmpfile_content= addLayer(m_instructions);
		writeTmpFile();
		Tank tmp = m_intelligence.getTankR().tankPhy;
		m_intelligence = new Intelligence(m_filename, m_intelligence.getIntels(), tmp, this);
		tmp.setIntelligence(m_intelligence);
	}
	

//=============================================================================
// Méthodes privées
	
	/**
	 * Génère un chaîne de 50 caractères dans l'objectif d'être le nom d'un 
	 * fichier temporaire. Elle commence par un '.' pour permettre d'être un 
	 * fichier caché sous les système UNIX.
	 * 
	 * @return une chaîne de caractères alphanumériques aléatoires
	 */
	private String generateRandomFilename()
	{
		String charset = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		String ret;
		ret = "."; // fichier caché
		for (int i = 0; i < 49; i++)
		{
			ret += charset.charAt((int) (Math.random() * charset.length())); // ajout d'un caractere aléatoire 
		}
		return ret;
	}
	
	private void importInstructionsFromFile(String path)
	/**
	 * chemin du script pour l'import de l'instruction
     * @param path
     */	
	{
		if (path == null)
		{
			m_instructions = "print \"Hello World !\"";
			m_tmpfile_content = addLayer(m_instructions);
			GraphicInterface.textAreaCode.setText(m_instructions);
			return ;
		}
		BufferedReader br = null;
		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader(path));

			while ((sCurrentLine = br.readLine()) != null) {
				m_instructions += sCurrentLine+'\n';
				//tmpFileContent += "print str(inspect.currentframe().f_back.f_lineno)";
				
						m_tmpfile_content = addLayer(m_instructions);
				
			}
			GraphicInterface.textAreaCode.setText(m_instructions);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/* Ecrit dans le fichier temporaire */
	private void writeTmpFile()
	/** 
	 * Ecrit dans le fichier temporaire 
	 */
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/ressources/"+m_tmpfile_name)));
		
			writer.write(m_tmpfile_content);
			writer.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}
	
	private String addLayer(String instr)
	/**
     * Retourne la string contenant le script python avec la surcouche
     * @param instr
     * @return tmpFileContentLayer
     */	
	{
		String tmpFileContentLayer = instr;
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.doNothing\\(\\)", "tank.doNothing(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.moveForward\\(\\)", "tank.moveForward(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.moveBackward\\(\\)", "tank.moveBackward(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.turnClockwise\\(\\)", "tank.turnClockwise(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.turnCounterClockwise\\(\\)", "tank.turnCounterClockwise(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.shoot\\(\\)", "tank.shoot(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.radar\\(\\)", "tank.radar(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.distanceOfForwardObstacle\\(\\)", "tank.distanceOfForwardObstacle(lineno())");
		tmpFileContentLayer = tmpFileContentLayer.replaceAll("tank.typeOfForwardObstacle\\(\\)", "tank.typeOfForwardObstacle(lineno())");
		return tmpFileContentLayer;
	}
	
}
