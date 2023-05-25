<template>
  <div>
    <div v-if="videoData.length !== 0" id="body">
      <div v-for="(videoItem, index) in videoData" :key="index" class="col">
        <div class="container text-center">
          <div>
            <h2 class="p-2">{{ part }}</h2>
          </div>
          <div class="row row-cols-4">
            <div class="col-6">
              <div>
                <a :href="`review.html?${videoItem.id}`" :id="videoItem.id">
                  <img
                    class="w-100"
                    :src="`@assets/img/${videoItem.id}.jpg`"
                    alt=""
                  />
                </a>
              </div>
              <div class="video-info">
                <div>
                  <div>{{ videoItem.title }}</div>
                </div>
              </div>
            </div>
            <div class="col-6">
              <div>
                <a
                  :href="`review.html?${videoItem.id}`"
                  :id="videoItem.id"
                >
                  <img
                    class="w-100"
                    :src="`img/${videoItem.id}.jpg`"
                    alt=""
                  />
                </a>
              </div>
              <div class="video-info">
                <div>
                  <div>{{ videoItem.title }}</div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div v-else>버퍼링...</div>
  </div>
</template>

<script>
export default {
  name: "VideoPart",
  props: ["videoData","part"],
};
</script>

<style></style>
