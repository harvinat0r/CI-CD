<template>
  <main class="container">
		<div class="d-flex justify-content-center m-5">
			<iframe id="player" width="720" height="480"
				:src="`http://www.youtube.com/embed/${video.id}`" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				allowfullscreen=""></iframe>
		</div>

		<div class="">
			<div class="m-3 p-3 border-top d-flex justify-content-between">
				<!--모달 트리거-->
				<b-button type="button" v-b-modal="'my-modal'">글 작성</b-button>
				<!--모달-->
				<b-modal id="my-modal" title="게시글 작성">
            <form method="POST" action="main">
                <p>제목:</p>
                <input v-model="title" type="text"
                  class="form-control" /> <br />
                <p>내용:</p>
                <input v-model="content" type="text"
                  class="form-control" />
            </form>
            <template #modal-footer>
              <b-button v-b-modal.modal-close_visit class="btn btn-danger w-25 m-1">Close</b-button>
              <b-button v-b-modal.modal-close_visit class="btn btn-success w-25 m-1" @click="createReview">Submit</b-button>
            </template>
        </b-modal>
				<input class="col-4 h-70 m-2 form-control" type="search"
					placeholder="검색어를 입력하세요" />
			</div>
			<div class="m-2 border-top p-2 border-top">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th scope="col" class="col-1">#</th>
							<th scope="col" class="col-5">제목</th>
							<th scope="col" class="col-2">작성자</th>
							<th scope="col" class="col-2">조회수</th>
							<th scope="col" class="col-2">작성일</th>
						</tr>
					</thead>
					<tbody id="reivew-list">
							<tr v-for="review in reviews" :key="review.id">
								<td>{{review.id}}</td>
								<td><router-link :to="`/review/${review.id}`">
										{{review.title}}</router-link></td>
								<td>{{review.writer}}</td>
								<td>{{review.viewCnt}}</td>
								<td>{{review.createdAt}}</td>
							</tr>
					</tbody>
				</table>
			</div>
		</div>
	</main>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "VideoDetail",
  data(){
    return {
      title: "",
      content: "",
    }
  },
  methods: {
    async setVideo(id) {
      await this.$store.dispatch("setVideo", id);
    },
    async setReviews(id) {
      await this.$store.dispatch("setReviews", id);
    },
    createReview(){
      const pathName = new URL(document.location).pathname.split("/");
      const videoId = pathName[pathName.length - 1];
      const review= {
        videoId: videoId,
        title: this.title,
        content:this.content,
        writer: "운동장철봉"
      }
      console.log(review)
      this.$store.dispatch("createReview",review)
    }
  },
  computed: {
    ...mapState(["video"]),
    ...mapState(["reviews"])
  },
  created() {
    const pathName = new URL(document.location).pathname.split("/");
    const id = pathName[pathName.length - 1];
    this.setVideo(id);
    this.setReviews(id);
  },
}
</script>

<style>

</style>