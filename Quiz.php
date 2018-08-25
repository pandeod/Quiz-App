<?php

require_once('DbController.php');

//code to retrive data from mysql database.
class Faculty {
    int fid;
    String email;
    String password;
}

class Schedule {
    int sid;
    String date;
    String time;
    int roomNo;
    String subject;
    int fid;
    String title;
    String description;
}

class Quiz {
    public function validateFaculty() {

    }
    public function getQuiz() {

    }
    public function updateQuiz() {

    }
}

?>