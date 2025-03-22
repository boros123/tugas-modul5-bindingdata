/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package modul3contoh2;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Lenovo
 */
public class MasterDataController implements Initializable {
    
    @FXML
    private Hyperlink linkdash;

    @FXML
    private void handleLinkDash(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) linkdash.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @FXML
    private Button btnLogoutM;
    
    
    @FXML
    private void handleButtonLogoutAction(ActionEvent event)throws Exception{
        Main main = new Main ();
        main.changeScene("Main.fxml");    
    }
    

      private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    
//    Organisasi 
    @FXML
    private TableView<Organisasi> Tblorganisasi;
  
    @FXML
    private TableColumn<Organisasi, String> colIdO;

    @FXML
    private TableColumn<Organisasi, String> colNamaO;
    
    @FXML
    private Button btnAddO;
    
     @FXML
    private Button btnUpdateO;
     
     @FXML
    private Button btnDeleteO;
    
    
    @FXML
    private ToggleGroup Organisasi;
    
    @FXML
    private RadioButton radioOr1;
    
    @FXML
    private RadioButton radioOr2;
    
    @FXML
    private RadioButton radioOr3;
    
    
    @FXML
    private TextField txtOrganisasi; // Pastikan ini ada di FXML
    
    @FXML
    private Organisasi selectedOrganisasi;
    
        private void clearFieldsO() {
        txtOrganisasi.clear();
        selectedOrganisasi = null; 
    }
    
     

    @FXML
    private void selectOrganisasi(Organisasi organisasi) {
        if (organisasi != null) {
            selectedOrganisasi = organisasi;
            txtOrganisasi.setText(organisasi.getNama()); 
        }
    }
    
    @FXML
private void addOrganisasi() {  
    String nama = txtOrganisasi.getText(); 
    
    String jenis = ((RadioButton) Organisasi.getSelectedToggle()).getText(); 

    if (nama.isEmpty()) {
        showAlert("Input Error", "Field tidak boleh kosong!");
        return;
    }

 
    Organisasi newOrganisasi = new Organisasi(nama, jenis);
    OrganisasiDAO.addOrganisasi(newOrganisasi);
    
    
    loadDataOrganisasi();
    clearFieldsO();
}

@FXML
private void updateOrganisasi() {  
    if (selectedOrganisasi == null) {
        showAlert("Selection Error", "Tidak ada organisasi yang dipilih!");
        return;
    }

    String nama = txtOrganisasi.getText(); 
    String jenis = ((RadioButton) Organisasi.getSelectedToggle()).getText(); 

    if (nama.isEmpty()) {
        showAlert("Input Error", "Field tidak boleh kosong!");
        return;
    }

    selectedOrganisasi.setNama(nama);
    selectedOrganisasi.setJenis(jenis);

    OrganisasiDAO.updateOrganisasi(selectedOrganisasi);

    loadDataOrganisasi();
    clearFieldsO();
}

  @FXML
    private void deleteOrganisasi() {
        if (selectedOrganisasi == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }

//        UserDAO.deleteUser(selectedUser.getUsername());
organisasiDAO.deleteOrganisasi(selectedOrganisasi.getNama());

        loadDataOrganisasi(); 
        clearFields();
    }

@FXML
private OrganisasiDAO organisasiDAO;

    
@FXML
private void loadDataOrganisasi() { 
    OrganisasiDAO organisasiDAO = new OrganisasiDAO(); 
    ObservableList<Organisasi> organisasiList = FXCollections.observableArrayList(organisasiDAO.getOrganisasi());
    Tblorganisasi.setItems(organisasiList);   
    comboxOrg.setItems(organisasiList);  
    
}

// end organisasi crud
   

//kota crud
    @FXML
    private Button btnAddK;
    
       @FXML
    private Button btnDeleteK;
       @FXML
    private Button btnUpdateK;
       
    
    @FXML
    private TextField txtKota; // Pastikan ini ada di FXML
    @FXML
    private Kota selectedKota;
    
        private void clearFields() {
        txtKota.clear();
        selectedKota = null; 
    }
    
 

    @FXML
    private void selectKota(Kota kota) {
        if (kota != null) {
            selectedKota = kota;
            txtKota.setText(kota.getNama()); 
        }
    }
    
    @FXML
    private void addKota() {  
    String nama = txtKota.getText();

    if (nama.isEmpty()) {
        showAlert("Input Error", "Field tidak boleh kosong!");
        return;
    }

    Kota newKota = new Kota(nama);
    KotaDAO.addKota(newKota);
    loadDataKota();
    clearFields();
}
    
    @FXML
private void updateKota() {  
    if (selectedKota == null) {
        showAlert("Selection Error", "Tidak ada kota yang dipilih!");
        return;
    }

    String nama = txtKota.getText();

    if (nama.isEmpty()) {
        showAlert("Input Error", "Field tidak boleh kosong!");
        return;
    }

    selectedKota.setNama(nama);
    KotaDAO.updateKota(selectedKota);
    loadDataKota();
    clearFields();
}


    @FXML
    private TableView<Kota> Tblkota;
    
    @FXML
    private TableColumn<Kota, String> colIdK;

    @FXML
    private TableColumn<Kota, String> colNamaK;
    
  
private KotaDAO kotaDAO; 
@FXML
private void loadDataKota() {
    kotaDAO = new KotaDAO(); 
    ObservableList<Kota> kotaList = FXCollections.observableArrayList(kotaDAO.getKota());
    Tblkota.setItems(kotaList);
    comboxKota.setItems(kotaList);
}

  @FXML
    private void deleteKota() {
        if (selectedKota == null) {
            showAlert("Selection Error", "Tidak ada user yang dipilih!");
            return;
        }

//        UserDAO.deleteUser(selectedUser.getUsername());
KotaDAO.deleteKota(selectedKota.getNama());

        loadDataKota(); 
        clearFields();
    }
//end kota crud


//anggota

  @FXML
    private TableView<Anggota> Tblanggota;
    
    @FXML
    private TableColumn<Anggota, String> colId;

    @FXML
    private TableColumn<Anggota, String> colNama;
    
    @FXML
    private TableColumn<Anggota, String> colJenis;
        
    @FXML
    private TableColumn<Anggota, String> colOrganisasi;
    
    @FXML
    private Button btnUpdateA;
      @FXML
    private Button btnDeleteA;
    
    @FXML
    private Button btnAddA;
    @FXML
    private ToggleGroup JK;
    @FXML
    private RadioButton jkW;
    @FXML
    private RadioButton jkP;
    @FXML
    private ToggleGroup Jenis;
    @FXML
    private RadioButton radioJ1;
    @FXML
    private RadioButton radioJ2;
    @FXML
    private RadioButton radioJ3;
    @FXML
    private DatePicker tglDaftar; 
    @FXML
    private TextField txtNamaAng; 
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtTelpon;
    @FXML
    private TextField txtAlamat;
    @FXML
    private ComboBox<Kota>  comboxKota;
    @FXML
    private ComboBox<Organisasi>  comboxOrg;
    
    
    
   
    
    
  private void clearFieldsA() {
    txtNamaAng.clear();
    txtEmail.clear();
    txtTelpon.clear();
    txtAlamat.clear();
    tglDaftar.setValue(null);
    comboxKota.getSelectionModel().clearSelection();
    comboxOrg.getSelectionModel().clearSelection();
    JK.selectToggle(null);
    Jenis.selectToggle(null);
}

    
  private AnggotaDAO anggotaDAO; 
@FXML
private void loadDataAnggota() {
    anggotaDAO = new AnggotaDAO(); 
    ObservableList<Anggota> anggotaList = FXCollections.observableArrayList(anggotaDAO.getAnggota());
    Tblanggota.setItems(anggotaList);
}  
    


@FXML
private void selectAnggota(Anggota anggota) {
    if (anggota != null) {
        txtNamaAng.setText(anggota.getNama());
        txtEmail.setText(anggota.getEmail());
        txtTelpon.setText(anggota.getTelpon());
        txtAlamat.setText(anggota.getAlamat());
        tglDaftar.setValue(LocalDate.parse(anggota.getTanggal_daftar())); 

       
        for (Kota kota : comboxKota.getItems()) {
            if (kota.getId().equals(anggota.getId_kota())) {
                comboxKota.getSelectionModel().select(kota);
                break;
            }
        }

      
        for (Organisasi organisasi : comboxOrg.getItems()) {
            if (organisasi.getId().equals(anggota.getId_organisasi())) {
                comboxOrg.getSelectionModel().select(organisasi);
                break;
            }
        }

       
        if ("P".equalsIgnoreCase(anggota.getJenis_kelamin())) {
            jkP.setSelected(true);
        } else {
            jkW.setSelected(true);
        }

       String jenis = anggota.getJenis(); 
        if (jenis.equalsIgnoreCase("Staff")) {
            radioJ1.setSelected(true);
        } else if (jenis.equalsIgnoreCase("Dosen")) {
            radioJ2.setSelected(true);
        } else if (jenis.equalsIgnoreCase("Mahasiswa")) {
            radioJ3.setSelected(true);
        }
    }
}

   @FXML
private void addAnggota() {  
    
    Kota selectedKota = comboxKota.getValue();
    Organisasi selectedOrganisasi = comboxOrg.getValue();
    String nama = txtNamaAng.getText();
    String alamat = txtAlamat.getText();
    String telpon = txtTelpon.getText();
    String email = txtEmail.getText();
    LocalDate tanggalDaftar = tglDaftar.getValue();
    
    
    RadioButton selectedJK = (RadioButton) JK.getSelectedToggle();
    String jenisKelamin = (selectedJK != null) ? selectedJK.getText() : "";

  
    RadioButton selectedJenis = (RadioButton) Jenis.getSelectedToggle();
    String jenis = (selectedJenis != null) ? selectedJenis.getText() : "";

  
    if (selectedKota == null || selectedOrganisasi == null || nama.isEmpty() || email.isEmpty() ||
        telpon.isEmpty() || alamat.isEmpty() || tanggalDaftar == null || 
        jenisKelamin.isEmpty() || jenis.isEmpty()) {
        showAlert("Input Error", "Semua field harus diisi!");
        return;
    }

   
    Anggota newAnggota = new Anggota(
        selectedKota.getId(),  
        selectedOrganisasi.getId(), 
        nama,
        alamat,
        telpon,
        email,
        tanggalDaftar.toString(),
        jenisKelamin,
        jenis
    );

    
    AnggotaDAO.addAnggota(newAnggota);

 
    loadDataAnggota();
    clearFieldsA();
}


@FXML
private void updateAnggota() {
    
    Anggota selectedAnggota = Tblanggota.getSelectionModel().getSelectedItem();
    if (selectedAnggota == null) {
        showAlert("Selection Error", "Tidak ada anggota yang dipilih!");
        return;
    }

 
    Kota selectedKota = comboxKota.getValue();
    Organisasi selectedOrganisasi = comboxOrg.getValue();
    String nama = txtNamaAng.getText();
    String alamat = txtAlamat.getText();
    String telpon = txtTelpon.getText();
    String email = txtEmail.getText();
    LocalDate tanggalDaftar = tglDaftar.getValue();
    
   
    RadioButton selectedJK = (RadioButton) JK.getSelectedToggle();
    String jenisKelamin = (selectedJK != null) ? selectedJK.getText() : "";

   
    RadioButton selectedJenis = (RadioButton) Jenis.getSelectedToggle();
    String jenis = (selectedJenis != null) ? selectedJenis.getText() : "";

    // Validasi input
    if (selectedKota == null || selectedOrganisasi == null || nama.isEmpty() || email.isEmpty() ||
        telpon.isEmpty() || alamat.isEmpty() || tanggalDaftar == null || 
        jenisKelamin.isEmpty() || jenis.isEmpty()) {
        showAlert("Input Error", "Semua field harus diisi!");
        return;
    }

    selectedAnggota.setId_kota(selectedKota.getId());
    selectedAnggota.setId_organisasi(selectedOrganisasi.getId());
    selectedAnggota.setNama(nama);
    selectedAnggota.setAlamat(alamat);
    selectedAnggota.setTelpon(telpon);
    selectedAnggota.setEmail(email);
    selectedAnggota.setTanggal_daftar(tanggalDaftar.toString());
    selectedAnggota.setJenis_kelamin(jenisKelamin);
    selectedAnggota.setJenis(jenis);
    
    AnggotaDAO.updateAnggota(selectedAnggota); 
    loadDataAnggota();
    clearFieldsA();
}
   
    
@FXML
private void deleteAnggota() {
    Anggota selectedAnggota = Tblanggota.getSelectionModel().getSelectedItem();
    if (selectedAnggota == null) {
        showAlert("Selection Error", "Tidak ada anggota yang dipilih!");
        return;
    }

    AnggotaDAO.deleteAnggota(selectedAnggota.getNama());
    loadDataAnggota();
    clearFieldsA();
}

//    end anggota crud
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       // Set nilai untuk kolom tabel
        colIdK.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaK.setCellValueFactory(new PropertyValueFactory<>("nama"));

        loadDataKota();
        
        Tblkota.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectKota(newValue)
        );
        
        
        colIdO.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaO.setCellValueFactory(new PropertyValueFactory<>("nama"));

        loadDataOrganisasi();
        
        Tblorganisasi.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> selectOrganisasi(newValue)
        );
        
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
    colJenis.setCellValueFactory(new PropertyValueFactory<>("jenis"));
    colOrganisasi.setCellValueFactory(new PropertyValueFactory<>("NamaOrganisasi"));

    loadDataAnggota();

    Tblanggota.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> selectAnggota(newValue)
    );
        
        
    }    
    
}
