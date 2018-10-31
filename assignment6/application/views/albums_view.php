<p class="bg-success">
<?php // if($this->session->flashdata('login_success')): ?>
<?php // echo $this->session->flashdata('login_success'); ?>
<?php // endif; ?>
</p>

<p class="bg-danger">
<?php // if($this->session->flashdata('login_failed')): ?>
<?php // echo $this->session->flashdata('login_failed'); ?>
<?php // endif; ?>
</p>

<div class="jumbotron">
	<h2 class="text-center">Welcome to the Music Collection App</h2>
</div>

<?php if(isset($albums)): ?>

<div class="panel panel-primary">
	<div class="panel-heading"><h3>Albums</h3></div>
	<div class="panel-body">
	<ul class="list-group">

<?php // var_dump($albums); ?>

<?php foreach($albums as $album): ?>

	<li class="list-group-item"><a href="<?php echo base_url();?>albums/display/<?php echo $album->id ?>">
	<?php echo $album->title . " by " . $album->artist; ?> </a></li>
	<?php // echo  $album->track_count . "<br>"; ?>
	
	  <?php endforeach; ?>

<?php endif; ?>
	</ul>
</div>

</div> <!-- ENd of panel-->
