$(function () {
   bindingEvents();
   if($('#description').val()) {
       $('#modal-update').modal('show');
   }
   if($('#message').val()) {
       window.alert($('#message').val());
   }
});

function bindingEvents() {
   handleBtnUpdateClick();
   handleBtnDeleteClick();
   handleBtnAddClick();
}

function bindingTotoToForm(data = {}) {
    $('#id').val(data.id || '');
    $('#description').val(data.description || '');
    $('#targetDate').val(data.targetDate || '');
}
function handleBtnUpdateClick() {
   const btn = $('.btn-update');
   btn.unbind('click')
   btn.on('click', function () {
      const todoId = $(this).data('id');
      $.when($.ajax(`todo/${todoId}`)).then(function (data) {
          bindingTotoToForm(data)
         $('#modal-update').modal('show');
      })
   })
}

function handleBtnAddClick() {
    const btn = $('#btn-add');
    btn.unbind('click');
    btn.on('click', function () {
        bindingTotoToForm();
        $('#modal-update').modal('show');
    });
}

function handleBtnDeleteClick() {
   const btn = $('.btn-delete');
   btn.unbind('click');
   btn.on('click', function () {
      const todoId = $(this).data('id');
      const confirm = window.confirm('Do you really want to delete this');
      if (confirm) {
          $.ajax({
            type: 'DELETE',
            url: `todo/${todoId}`,
            contentType: "application/json",
            dataType: 'json',
            timeout: 120000,
            beforeSend: function (xhr) {
            }
         }).done(function (data) {
             window.location.reload();
         }).fail(function (jqXHR, textStatus, errorThrown) {
            window.alert("Error: " + errorThrown)
         });
      }
   })
}