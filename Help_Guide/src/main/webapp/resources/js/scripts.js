let newId = 0;
let subMenuWasExecuted = [];

function changeActive(button){
    newId++;
    let actBut = document.getElementById('active');
    let actSub = document.getElementById('activeSub');
    let newActBut = document.getElementById(button);
    let newActSub = document.getElementById(button+'Sub');
    if (actBut.id != button && actSub != (button+'Sub')){
        actBut.setAttribute("class","menu-value");
        actBut.id = "unactive"+(newId).toString();
        actSub.setAttribute("class","unact-sub");
        actSub.id = "unactive"+(newId).toString()+'Sub';}
    newActBut.id="active";
    newActSub.id="activeSub";
    document.getElementById("active").setAttribute("class", "active-button");
    document.getElementById("activeSub").setAttribute("class", "active-sub");
}

function getDocument(path,button){
    let targetUrl = 'http://localhost:8080/guide/get_guide/' + path;
    fetch(targetUrl)
        .then(response => response.json())
        .then(data => {
            document.getElementById('guide-body').innerHTML=data.document;
            getSubMenu(path);
        })
        .catch(error => console.error(error))
    changeActive(button);
}

function getMenu(){
    let diez=window.location.href.search("#");
    let curUrl='';
    if (diez>0)
        curUrl=window.location.href.substring(28,diez);
    else
        curUrl=window.location.href.substring(28);
    let container = document.getElementById('menu-panel');
    fetch('http://localhost:8080/guide/menu')
        .then(response => response.json())
        .then(data => {
            data.forEach(function build(x){
                let menuButton = '<li><p onclick="getDocument(\''+x.url+'\',this.id)" id=\"'+x.url+'\" class="menu-value">'+x.caption+'</p><ul id="'+x.url+'Sub'+'"></ul></li>';

                container.innerHTML += menuButton;
                if (curUrl == x.url) {
                    document.getElementById(x.url).setAttribute("class", "active-button");
                    document.getElementById(x.url).setAttribute("id", "active");
                    document.getElementById(x.url+'Sub').setAttribute("class", "active-sub");
                    document.getElementById(x.url+'Sub').setAttribute("id", "activeSub");
                    getSubMenu(curUrl);
                }
            });
        })
        .catch(error => console.error(error))

}

function getSubMenu(path) {
    let searchField = document.getElementById("guide-body");
    if (subMenuWasExecuted.includes(path) !=true){
    let divs = searchField.querySelectorAll('div');
    divs.forEach(function buildSub(x){
        let container = document.getElementById('activeSub');
        let menuSubPar = '<li><a href="#'+x.id+'\" class="sub-menu-val" >'+x.querySelector('h1').textContent+'</a></li>';

        container.innerHTML += menuSubPar;
    });
        subMenuWasExecuted.push(path);
    }
}

        /*onclick="activeSub(this)"

        function activeSub(subButton){
            let curSub = document.querySelector(".currentSub");
            if (curSub!=null && curSub != subButton)
            curSub.setAttribute("class","sub-menu-val");

            subButton.setAttribute("class","currentSub");
        }*/


$(document).ready(function () {
    $(document).on("scroll", onScroll);

    //smoothscroll
    $('a[href^="#"]').on('click', function (e) {
        e.preventDefault();
        $(document).off("scroll");

        $('a').each(function () {
            $(this).removeClass('currentSub');
        })
        $(this).addClass('currentSub');

        var target = this.hash,
            menu = target;
        $target = $(target);
        $('html, body').stop().animate({
            'scrollTop': $target.offset().top+2
        }, 500, 'swing', function () {
            window.location.hash = target;
            $(document).on("scroll", onScroll);
        });
    });
});

function onScroll(event){
    var scrollPos = $(document).scrollTop();
    $('#menu-center a').each(function () {
        var currLink = $(this);
        var refElement = $(currLink.attr("href"));
        if (refElement.position().top <= scrollPos && refElement.position().top + refElement.height() > scrollPos) {
            $('#menu-panel ul li a').removeClass("currentSub");
            currLink.addClass("currentSub");
        }
        else{
            currLink.removeClass("currentSub");
        }
    });
}