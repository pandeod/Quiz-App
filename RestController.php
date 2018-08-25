<?php

require_once("QuizRestHandler.php");

$view = '';
if($isset($_GET['view'])) {
    $view = $_GET['view'];

    switch($view) {
        case 'all':
            //create object and call the function
            break;
        case '':
            // 404 error
            break;
    }
}

?>