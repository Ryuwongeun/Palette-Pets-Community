import {lazy, Suspense} from "react";
import {Navigate} from "react-router-dom";
import IsLogin from "./IsLogin.jsx";

const Loading = <div>Loading....</div>
const HotSpotList = lazy(() => import("../components/hotSpot/HotSpotList.jsx"))
const HotSpotDetails = lazy(() => import("../components/hotSpot/HotSpotDetails.jsx"))
const HotSpotWrite = lazy(() => import("../components/hotSpot/HotSpotWrite.jsx"))
const HotSpotUpdate =lazy(() => import("../components/hotSpot/HotSpotUpdate.jsx"))


const hotSpotRouter = () => {
    return [
        {
            path: "",
            element: <Navigate replace={true} to="list" />
        },
        {
            path: "list",
            element: <Suspense fallback={Loading}><HotSpotList/></Suspense>
        },
        {
            path: "details/:id",
            element: <Suspense fallback={Loading}><IsLogin Component={<HotSpotDetails/>} /></Suspense>
        },
        {
            path: "write",
            element: <Suspense fallback={Loading}><IsLogin Component={<HotSpotWrite/>} /></Suspense>
        },
        {
            path: "update/:id",
            element: <Suspense fallback={Loading}><IsLogin Component={<HotSpotUpdate/>} /></Suspense>
        },
    ]
}
export default hotSpotRouter;