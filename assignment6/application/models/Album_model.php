<?php

class Album_model extends CI_Model {


    function __construct()
    {
        // Construct the parent class
        parent::__construct();

	}

	public function get_all_albums() {
		$query = $this->db->get('albums');
		return $query->result();
	}


	// public function create_project($data) {
	//
	// 	$insert_query = $this->db->insert('projects', $data);
	// 	return $insert_query;
	//
	// }

	public function add_album($data) {
		$insert_query = $this->db->insert('albums', $data);
		return $insert_query;

	}

	public function delete_album($id) {
		$this->db->where('id', $id);
		$this->db->delete('albums');
	}

}

?>
