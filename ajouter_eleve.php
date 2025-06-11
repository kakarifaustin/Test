<?php include('includes/header.php'); ?>
<div class="card card-primary">
  <div class="card-header">
    <h3 class="card-title">Ajouter un élève</h3>
  </div>
  <form action="traitement_eleve.php" method="POST" enctype="multipart/form-data">
    <div class="row">
  <!-- Partie gauche : tous les champs sauf photo -->
  <div class="col-md-8">
    <div class="form-row">
      <div class="form-group">
        <label>Nom</label>
        <input type="text" name="nom" class="form-control" required>
      </div>
      <div class="form-group ">
        <label>Prénom</label>
        <input type="text" name="prenom" class="form-control" required>
      </div>
    </div>

    <div class="form-row">
      <div class="form-group ">
        <label>Date de naissance</label>
        <input type="date" name="date_naissance" class="form-control" required>
      </div>
      <div class="form-group ">
        <label>Genre</label>
        <select name="genre" class="form-control">
          <option>Masculin</option>
          <option>Féminin</option>
        </select>
      </div>
    </div>

    <div class="form-row">
      <div class="form-group ">
        <label>Classe</label>
        <input type="text" name="classe" class="form-control" required>
      </div>
      <div class="form-group">
        <label>Téléphone</label>
        <input type="text" name="telephone" class="form-control">
      </div>
    </div>

    <div class="form-group">
      <label>Adresse</label>
      <textarea name="adresse" class="form-control"></textarea>
    </div>
  </div>

  <!-- Partie droite : photo -->
  <div class="col-md-4">
  <div class="form-group">
    <label>Photo</label>
    <input type="file" name="photo" class="form-control-file" id="photoInput" accept="image/*">
  </div>

  <div class="form-group text-center">
    <img id="previewImage"
         src="#"
         alt="Aperçu de la photo"
         style="
           max-width: 100%;
           height: auto;
           display: none;
           border-radius: 10px;
           border: 3px solid #007bff;
           padding: 4px;
           box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
           background-color: white;
         " />
  </div>
</div>


<!-- Script pour l’aperçu -->
<script>
  document.getElementById('photoInput').addEventListener('change', function (event) {
    const file = event.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onload = function (e) {
        const preview = document.getElementById('previewImage');
        preview.src = e.target.result;
        preview.style.display = 'block';
      }
      reader.readAsDataURL(file);
    }
  });
</script>


    <div class="card-footer">
      <button type="submit" class="btn btn-primary">Enregistrer</button>
    </div>
    
</div>
  </form>
</div>
<?php include('includes/footer.php'); ?>

