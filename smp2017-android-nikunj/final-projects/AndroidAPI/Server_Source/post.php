<?php
	$response=array();
	$conn=mysqli_connect("localhost","root","","practice");
	if($conn && isset($_POST["namez"]) && isset($_POST["descp"])){
		$nam=$_POST["namez"];
		$des=$_POST["descp"];
		$qry=mysqli_query($conn,"INSERT INTO `Datas` (`namez`, `descp`) VALUES ('$nam', '$des')");
		if($qry){
			$response["success"]=1;
		}
		else{
			$response["success"]=0;
		}
		echo json_encode($response);
	}
	else{
		echo "Soory";
	}
	
?>