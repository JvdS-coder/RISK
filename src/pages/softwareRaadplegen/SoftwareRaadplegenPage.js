import React from 'react';
import { Link } from 'react-router-dom';
import '../css/risk.css';
import '../css/nav_menu.css';

function SoftwareRaadplegenPage() {
  function verstuurFormulier() {
    // verstuur alles naar de backend met een axios.post('');
  }

  return(
    <>
      <header>
        <a href="/">
          <div><h1>Registratie Informatie Systemen & Knowledgebase</h1></div>
        </a>
      </header>

      <nav>
        <div>
          <center>
          <nav className="menu">
          <ol>
            <li className="menu-item">
              <a href="#0">Toevoegen</a>
              <ol className="sub-menu">
                <li className="menu-item"><Link to="/computer-toevoegen">Computers</Link></li>
                <li className="menu-item"><Link to="/randapparatuur">Randapparatuur</Link></li>
                <li className="menu-item"><Link to="/software_toevoegen">Software</Link></li>
                <li className="menu-item"><Link to="/leverancier_toevoegen">Leverancier</Link></li>
                <li className="menu-item"><Link to="/storing_toevoegen">Storingen</Link></li>
            </ol>
            </li>
            <li className="menu-item">
              <a href="#0">Raadplegen</a>
              <ol className="sub-menu">
                <li className="menu-item"><a href="raadplegen_computer.html">Computers</a></li>
                <li className="menu-item"><a href="raadplegen_randapparatuur.html">Randapparatuur</a></li>
                  <li className="menu-item"><a href="raadplegen_software.html">Software</a></li>
                  <li className="menu-item"><a href="raadplegen_leverancier.html">Leverancier</a></li>
                  <li className="menu-item"><a href="raadplegen_storingen.html">Storingen</a></li>
                  <li className="menu-item"><a href="raadplegen_knowledgebase.html">Knowledgebase</a></li>
              </ol>
            </li>
            <li className="menu-item">
              <a href="#0">Wijzigen</a>
              <ol className="sub-menu">
                <li className="menu-item"><a href="wijzigen_computer.html">Computers</a></li>
                <li className="menu-item"><a href="wijzigen_randapparatuur.html">Randapparatuur</a></li>
                <li className="menu-item"><a href="wijzigen_software.html">Software</a></li>
                <li className="menu-item"><a href="wijzigen_leverancier.html">Leverancier</a></li>
                <li className="menu-item"><a href="wijzigen_storingen.html">Storingen</a></li>
                <li className="menu-item"><a href="wijzigen_knowledgebase.html">Knowledgebase</a></li>
              </ol>
            </li>
            <li className="menu-item">
              <a href="#0">Verwijderen</a>
              <ol className="sub-menu">
                <li className="menu-item"><a href="verwijderen_computer.html">Computers</a></li>
                <li className="menu-item"><a href="verwijderen_randapparatuur.html">Randapparatuur</a></li>
                <li className="menu-item"><a href="verwijderen_software.html">Software</a></li>
                <li className="menu-item"><a href="verwijderen_leverancier.html">Leverancier</a></li>
                <li className="menu-item"><a href="verwijderen_storingen.html">Storingen</a></li>
                <li className="menu-item"><a href="verwijderen_knowledgebase.html">Knowledgebase</a></li>
              </ol>
            </li>
            <li className="menu-item"><a href="overzichten.html">Statistics</a></li>
            <li className="menu-item"><a href="over_RISK.html">Over RISK</a></li>
          </ol>
        </nav>
      </center>
      </div>
      </nav>

    <section>
      <center>
        <blockquote>
          <div className="container">
            <form action="action_page.php">
              <h1>Toevoegen gegevens software applicaties</h1>
              <center>

              <table>
                  <tr>
                      <td><label for="Swnr"><b>SW-Nummer</b></label></td>
                      <td><input type="number" name="swnr" align="left" id="swnr" size="10" readonly /></td>
                  </tr>
                  <tr>
                    <td><label for="naam"><b>Naam applicatie</b></label></td>
                    <td><input type="text" name="naam" align="left" id="naam" size="60" required/></td>
                    <td><label for="heldesksupport"><b>Helpdesk support</b></label></td>
                    <td><input type="text" name="helpdesksupport"  align="left" id="helpdesksupport" size="30" required /></td>
                  </tr>
                  <tr>
                    <td><label for="versie"><b>Versie applicatie</b></label></td>
                    <td><input type="text" name="verie" align="left" id="versie" size="30" required/></td>
                    <td><label for="licentienummer"><b>Licentienummer</b></label></td>
                    <td><input type="text" name="licentienummer" align="left" id="licentienummer" size="30" required/></td>
                  </tr>
                  <tr>
                    <td><label for="levnr"><b>Leverancier nummer</b></label></td>
                    <td><input type="text" name="levnr" align="left" id="levnr" size="10" required/></td>
                    <td><label for="licentieaantal"><b>Licentie aantal</b></label></td>
                    <td><input type="text" name="licentieaantal" align="left" id="licentieaantal" size="30" required/></td>
                  </tr>
                  <tr>
                    <td><label for="klantnummer"><b>Klantnummer</b></label></td>
                    <td><input type="text" name="klantnummer" align="left" id="klantnummer" size="50" required/></td>
                    <td><label for="expiratiedatum"><b>Afloopdatum</b></label></td>
                    <td><input type="date" name="expiratiedatum" align="left" id="expiratiedatum" size="30" required/></td>
                  </tr>
                </table>
                <hr />
                <table>
                    <tr>
                        <td><label for="typeos"><b>Vereist operating system</b></label></td>
                        <td><input type="text" name="typeos" align="left" id="typeos" size="20" required /></td>
                        <td><label for="minopslaggroote"><b>Minimale opslagruimte</b></label></td>
                        <td><input type="text" name="minopslaggroote" align="left" id="minopslaggroote" size="20" required /></td>
                    </tr>
                    <tr>
                        <td><label for="minramgeheugen"><b>Minimaal ram geheugen</b></label></td>
                        <td><input type="text" name="minramgeheugen" align="left" id="minramgeheugen" size="20" required /></td>
                        <td><label for="minvideogeheugen"><b>Minimaal video geheugen</b></label></td>
                        <td><input type="text" name="minvideogeheugen" align="left" id="minvideogeheugen" size="20" required /></td>
                    </tr>
                </table>
              </center>
            </form>
          </div>
        </blockquote>
      </center>

          <center>
              <button type="submit" value="Submit" onClick={verstuurFormulier}><b>Bewaar ingevoerde gegevens</b></button>
              <button type="reset" value="Reset"><b>Cancel</b></button>
              <p></p>
              <p></p>
          </center>
  </section>

    <footer>
        Copyright ;&copy 2020 by J. G. van der Slik, Maarheeze
    </footer>
  </>
  );
}

export default SoftwareRaadplegenPage;
