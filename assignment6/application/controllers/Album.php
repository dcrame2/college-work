<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Album extends CI_Controller
{
	
    public function __construct()
    {
        parent::__construct();
        $this->load->model('album_model');
    }		

    public function index()
    {
	$this->load->database('album_model');
	$data['albums'] = $this->album_model->get_all_albums();

        $data['main_view'] = "albums_view";
        $this->load->view('layouts/main', $data);
    }
	
}
