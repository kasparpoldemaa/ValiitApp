<template>
  <div>
    <div>

      <button v-on:click="displayTableEvent()" type="button" class="btn btn-outline-danger">Loo üritus</button>
      <button v-on:click="displayTableStudent()" type="button" class="btn btn-outline-danger">Õpilased</button>

<!--    <div class="btn-group btn-group-toggle" data-toggle="buttons">-->
<!--&lt;!&ndash;      <label class="btn btn-info active">&ndash;&gt;-->
<!--&lt;!&ndash;        <input type="" name="options" id="option1" checked v-on:change="displayTableEvent()"> Loo&ndash;&gt;-->
<!--&lt;!&ndash;        üritus&ndash;&gt;-->
<!--&lt;!&ndash;      </label>&ndash;&gt;-->
<!--      <label class="btn btn-info">-->
<!--        <input type="radio" name="options" id="option2" v-on:click="viewStudents"> Õpilased-->
<!--      </label>-->

    </div>


    <div class="form" v-if="this.tableDivDisplay">
      <EventForm :add-new-event="addNewEvent" :event="event"/>
    </div>
  </div>

</template>

<script>
import EventForm from "@/components/EventForm";

export default {
  name: "AdminPageView",
  components: {EventForm},
  data: function () {
    return {

      event: {},
      tableDivDisplay: false
    };
  },
  methods: {

    displayTableEvent: function () {
      this.tableDivDisplay = true
    },

    hideTableEvent: function () {
      this.tableDivDisplay = false
    },


    addNewEvent: function () {

      this.$http.post("/event/add", this.event
      ).then(response => {
        this.hideTableEvent()
        console.log(response.data)
      }).catch(error => {
        console.log(error)
      })
    }
  }


}
</script>

<style scoped>

.form {
  display: inline-block;
  margin: auto 98vh;
  /*border: 2px solid red;*/
  /*margin-right: 100px;*/
}

div.form {
  display: grid;
  grid-template-columns: max-content max-content;
  grid-gap: 10px;
}

div.form label {
  text-align: right;
  margin-top: 10px
}

div.form label:after {
  content: ":";
}


</style>

