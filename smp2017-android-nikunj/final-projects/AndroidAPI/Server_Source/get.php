<?php
	
	
	$con=mysqli_connect("localhost","root","","practice");
	
	$response = array();
	if($con){
		$result=mysqli_query($con,"select * FROM Datas");
			$response["details"]=array();
			while($raw=mysqli_fetch_array($result)){
				$temp=array();
				$temp["namez"]=$raw["namez"];
				$temp["descp"]=$raw["descp"];
				array_push($response["details"],$temp);
			}
			$response["success"]=1;
		
		echo json_encode($response);
	}
	
?>