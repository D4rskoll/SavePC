$('h1').hide();

$('#inver').click(function(){
    $('#inver').css('background', '#09f');
    $('#primero').hide();
})
$('#ver').click(function(){
    $('#ver').css('background', '#a0a0a0');
    $('#primero').show();
})
    
$(function() {
    $('#primero').css('background', 'red');
    $('.segundo').css('background', 'green');
});


$('#ver').dblclick(function(){
    $('#primero').css('background', '#f0f0f0');
    
})

$('#wa').mouseenter(function(){
    $('#primero').hide();
    
})

