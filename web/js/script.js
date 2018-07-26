/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var uniid, uni_check;
function dataSender(id, check) {
    uni_id = id;
    uni_check = check;
}
function deleteData() {
    var xmlhttp;
    var class_name;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    if (uni_check === "staffDelete") {
        xmlhttp.open("GET", "StaffController?action=delete&staffno=" + uni_id + "&format=fragment", true);
        class_name = "staff-";
    } else if (uni_check === "catalogDelete") {
        xmlhttp.open("GET", "CatalogController?action=delete&catalogno=" + uni_id + "&format=fragment", true);
        class_name = "catalog-";
    } else if (uni_check === "memberDelete") {
        xmlhttp.open("GET", "MemberController?action=delete&memberno=" + uni_id + "&format=fragment", true);
        class_name = "member-";
    } else if (uni_check === "branchDelete") {
        xmlhttp.open("GET", "BranchController?action=delete&branchno=" + uni_id + "&format=fragment", true);
        class_name = "branch-";
    } else if (uni_check === "videoDelete") {
        xmlhttp.open("GET", "VideoController?action=delete&videono=" + uni_id + "&format=fragment", true);
        class_name = "video-";
    }else if (uni_check === "videoCopyDelete") {
        xmlhttp.open("GET", "VideoController?action=deletecopy&copyno=" + uni_id + "&format=fragment", true);
        class_name = "videocopy-";
    }
    xmlhttp.send(null);
    xmlhttp.onreadystatechange = function ()
    {
        if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
            console.log("Deleted");
            var row = document.getElementById(class_name + uni_id);
            row.parentNode.removeChild(row);
        }
    }
}
