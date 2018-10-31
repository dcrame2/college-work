<?php

defined('BASEPATH') OR exit('No direct script access allowed');

// This can be removed if you use __autoload() in config.php OR use Modular Extensions
/** @noinspection PhpIncludeInspection */
require APPPATH . 'libraries/REST_Controller.php';

/**
 * This is an example of a few basic user interaction methods you could use
 * all done with a hardcoded array
 *
 * @package         CodeIgniter
 * @subpackage      Rest Server
 * @category        Controller
 * @author          Phil Sturgeon, Chris Kacerguis
 * @license         MIT
 * @link            https://github.com/chriskacerguis/codeigniter-restserver
 */
class Api extends REST_Controller {

    function __construct()
    {
        // Construct the parent class
        parent::__construct();

        // $this->load->model('Project_model');

		$this->load->model('Album_model');

        // Configure limits on our controller methods
        // Ensure you have created the 'limits' table and enabled 'limits' within application/config/rest.php
        // $this->methods['projects_get']['limit'] = 500; // 500 requests per hour per user/key
        // $this->methods['projects_post']['limit'] = 100; // 100 requests per hour per user/key
        // $this->methods['projects_delete']['limit'] = 50; // 50 requests per hour per user/key
    }


    public function album_post()
    {


    /*  $data = array (
          "artist"=>"drake",
          "title"=>"right now",
          "upc"=>"album",
          "track_count"=> 8
        ); */

      $data = array(

        "artist" => $this->post('artist'),
        "title" => $this->post('title'),
        "upc" => $this->post('upc'),
        "track_count" => $this->post('track_count')

      );

      if ($this->album_model->add_album($data)) {
          $this->set_response($data, REST_Controller::HTTP_OK);
      }
      else{
        $this->set_response([
            'status' => FALSE,
            'message' => 'Album insert failed'
        ], REST_Controller::HTTP_BAD_REQUEST);
      }
    }

    public function album_delete()
    {

        $id = $this->get('id');

        $this->delete('id');




        if ($this->album_model->delete_album($id)) {
            $this->set_response([
              'status' => FALSE,
              'message' => 'Album was not deleted'
          ], REST_Controller::HTTP_BAD_REQUEST);
        }
        else{
          $this->set_response($id, REST_Controller::HTTP_OK);
        
        }


//         $this->album_model->delete_album($id);
        // $this->session->set_flashdata('project_deleted', 'Your Project has been deleted');
        // redirect("projects/index");

    }

    //
    // public function projects_get()
    // {
    //     // Users from a data store e.g. database
    //     $projects = $this->Project_model->get_projects();
    //
    //     // example way
    //     // $users = [
    //     //     ['id' => 1, 'name' => 'John', 'email' => 'john@example.com', 'fact' => 'Loves coding'],
    //     //     ['id' => 2, 'name' => 'Jim', 'email' => 'jim@example.com', 'fact' => 'Developed on CodeIgniter'],
    //     //     ['id' => 3, 'name' => 'Jane', 'email' => 'jane@example.com', 'fact' => 'Lives in the USA', ['hobbies' => ['guitar', 'cycling']]],
    //     // ];
    //
    //     // Check if the users data store contains projects (in case the database result returns NULL)
    //     if ($projects)
    //     {
    //         // Set the response and exit
    //         $this->response($projects, REST_Controller::HTTP_OK); // OK (200) being the HTTP response code
    //     }
    //     else
    //     {
    //         // Set the response and exit
    //         $this->response([
    //             'status' => FALSE,
    //             'message' => 'No projects were found'
    //         ], REST_Controller::HTTP_NOT_FOUND); // NOT_FOUND (404) being the HTTP response code
    //     }
    // } // close projects_get method

}
