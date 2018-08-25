<?php

require_once('SimpleRest.php');
require_once('Quiz.php');

class QuizRestHandler extends SimpleRest {
    function getQuiz() {
        //create object, call relevant function and store the data in $rawdata
        $rawdata = null;

        if(empty($rawdata)) {
            $statusCode = 404;
            $rawdata = array('error' => 'No quizzes found!');
        } else {
            $statusCode = 200;
        }

        $requestContentType = 'application/json';
        $this->setHttpHeaders($requestContentType, $statusCode);

        $result['output'] = $rawdata;

        if(strpos($requestContentType, 'application/json') !== false) {
            $response = json_encode($result);
            echo $response;
        }
    }
}

?>