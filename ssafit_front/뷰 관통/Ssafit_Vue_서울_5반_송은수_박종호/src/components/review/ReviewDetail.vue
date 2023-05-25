<template>
  <main class="container">
		<div class="d-flex flex-column justify-content-between m-5">
			<div class="d-flexjustify-content-between">
<router-link to="/"><b-button type="button">목록</b-button></router-link>
				<!--모달 트리거-->
			<b-button class="btn-success" type="button" v-b-modal="'my-modal'">수정</b-button>
			<b-button class="btn-danger" type="button" @click="deleteReview">삭제</b-button>
			</div>

			<div class="">
				<div class="m-3 p-3 border-top d-flex justify-content-between">
				<!--모달-->
				<b-modal id="my-modal" title="게시글 수정">
            <form method="POST" action="main">
                <p>제목:</p>
                <input v-model="review.title" type="text"
                  class="form-control" /> <br />
                <p>내용:</p>
                <input v-model="review.content" type="text"
                  class="form-control" />
            </form>
            <template #modal-footer>
              <b-button v-b-modal.modal-close_visit class="btn btn-danger w-25 m-1">Close</b-button>
              <b-button v-b-modal.modal-close_visit class="btn btn-success w-25 m-1" @click="updateReview">Submit</b-button>
            </template>
        </b-modal>
			</div>
			</div>
			<div class="container shadow w-75 mt-3">
				<div class="text-center">
					<div id="title" class="mb-3 fs-4">{{review.title }}</div>
					<ul class="list-unstyled">
						<li id="writer">{{review.writer }}</li>
						<li id="createdAt">{{review.createdAt }}</li>
						<li id="viewCnt">{{review.viewCnt }}</li>
					</ul>
				</div>
				<div id="content" class="text-center m-5 p-3 border-top">{{review.content }}</div>
			</div>
		</div>
	</main>
</template>

<script>
import {mapState} from "vuex"
export default {
	name: "ReviewDetail",
  methods: {
		setReview(id){
			this.$store.dispatch("setReview",id)
		},
		updateReview() {
      this.$store.dispatch("updateReview", this.review);
    },
    deleteReview() {
      this.$store.dispatch("deleteReview", this.review.id);
    },
  },
  computed: {
    ...mapState(["review"])
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.setReview(id);
  },
}
</script>

<style>

</style>