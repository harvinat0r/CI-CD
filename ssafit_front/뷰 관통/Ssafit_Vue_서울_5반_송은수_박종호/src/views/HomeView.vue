<template>
    <main class="container">
		<div>
			<div id="popular-text" class="fs-4 my-3">인기 동영상</div>
			<!--carousel slide-->
			<div class="d-flex justify-content-center">
      <b-container class="w-50">
        <b-carousel
          id="carousel-1"
          v-model="slide"
          :interval="4000"
          controls
          indicators
          background="#ababab"
          img-width="1024"
          img-height="480"  
          style="text-shadow: 1px 1px 2px #333;"
          @sliding-start="onSlideStart"
          @sliding-end="onSlideEnd"
        >
          <router-link  v-for="video in popularVideos" :key="video.id" :to="`video/${video.id}`">
          <b-carousel-slide
            :text="`${video.title}`"
            :img-src="`${video.thumbUrl}`"
          >
          </b-carousel-slide>
          </router-link>
        </b-carousel>
      </b-container>
		</div>
		</div>

		<div>
			<div>
				<div class="fs-4 my-3">운동 부위 선택</div>
				<div class="mb-4">

					<button class="btn btn-outline-secondary m-2 partBtn">전체</button>
					<button class="btn btn-outline-secondary m-2 partBtn">하체</button>
					<button class="btn btn-outline-secondary m-2 partBtn">상체</button>
					<button class="btn btn-outline-secondary m-2 partBtn">복근</button>
				</div>
			</div>

			<div class="w-120 h-90">
				<b-container id="video-list">
						<div v-for="row in 10" :key="row" class="row m-3 align-items-center">
								<div v-for="col in 4" :key="col" class="col-md-3">
									<router-link :to="`video/${videos[(row-1)*4+col-1].id}`">
										<div class="card" style="width: 100%">
											<img :src="`${videos[(row-1)*4+col-1].thumbUrl}`" class="card-img-top w-auto"
												alt="...">
											<div class="card-body">
												<h6 class="card-title text-truncate">{{videos[(row-1)*4+col-1].title}}</h6>
											</div>
										</div>
									</router-link >
								</div>
						</div>
				</b-container>
			</div>
		</div>
	</main>
</template>

<script>
import {mapGetters, mapState} from "vuex"
export default {
  name: 'HomeView',
  data() {
      return {
        slide: 0,
        sliding: null
      }
    },
    methods: {
      onSlideStart() {
        this.sliding = true
      },
      onSlideEnd() {
        this.sliding = false
      }
    },
  components: {
  },
  computed:{
    ...mapState(["videos"]),
    ...mapGetters(["popularVideos"])
  },
  created(){
    this.$store.dispatch("setVideos");
  }
}
</script>
<style scoped>
</style>